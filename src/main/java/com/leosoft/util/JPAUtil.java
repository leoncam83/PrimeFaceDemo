/**
 * 
 */
package com.leosoft.util;

import java.util.HashMap;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.postgresql.util.PSQLException;

/**
 * @author Leonardo Castro Mestra
 *
 */
public class JPAUtil {

//	static final Logger log = LogManager.getLogger(JPAUtil.class);

	private final static String JPA_PERSITENCE = "PrimeFaceDemo";

	private static EntityManagerFactory factory;

	private static Properties databaseKeyExcetion = null;

	static {
		factory = Persistence.createEntityManagerFactory(JPA_PERSITENCE);
		
//		if(databaseKeyExcetion == null){
//			databaseKeyExcetion = new Properties();
//			try {
//
//				databaseKeyExcetion.load(JPAUtil.class.getClassLoader().getResourceAsStream("databaseKey.properties"));
////				log.info("se cargo el archivo propertie de databaseKey");
//			} catch (IOException e) {
////				log.error(e);
//				e.getStackTrace();
//			}
//		}
		

	}


	public static EntityManager getManager() {
		if (!factory.isOpen()){
			factory = Persistence.createEntityManagerFactory(JPA_PERSITENCE);
		}
		return factory.createEntityManager();
	}

//	public void close(){
//		//		synchronized (factory) {
//		if (!factory.isOpen()){
//			factory.close();
//			//			}		
//		}
//	}

	public void clear() {
		factory.getCache().evictAll();
	}

	public void clear(Class<?> clase, Object arg) {
		factory.getCache().evict(clase, arg);
	}

	public void clear(Class<?> clase) {
		factory.getCache().evict(clase);
	}

	/****/

	/**
	 * Localiza el mensage de la base de datos 
	 * 
	 * @param PersistenceException
	 * @return HashMap{msg = mensaje devuelto, nivel = nivel del mensaje}
	 */
	public static HashMap<String, String> getExceptionDB(Exception pe) {		

		HashMap<String, String> mensaje = new HashMap<String, String>();

		String msg = null;
		String nivel = NivelError.WARRING.name();

		if(pe.getCause() instanceof PersistenceException) {
			PersistenceException e = (PersistenceException) pe.getCause();

			if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException){
				org.hibernate.exception.ConstraintViolationException ed = (org.hibernate.exception.ConstraintViolationException) e.getCause(); 


				System.err.println("error : " + e.getMessage() + " causa : " + e.getCause().toString());
				if(ed.getCause() instanceof PSQLException){
					PSQLException ep = (PSQLException) ed.getCause();
					//

					System.err.println("exepcion de posgresql: " + ep.getMessage());

					int index = ep.getMessage().indexOf("«");
					int index2 = ep.getMessage().indexOf("»");										
					String key = ep.getMessage().substring(index+1, index2);

					System.err.println("entro en la exepcion dde posgresql " + key);
					msg = getDatabaseKeyException(key);

				}	

			}
		}

		if(msg == null){
//			log.error(pe.getMessage(), pe);
			msg = pe.getMessage();
			nivel =  NivelError.WARRING.name();
		}


		mensaje.put("msg", msg);
		mensaje.put("nivel", nivel);

		return mensaje;
	}

	public static String getDatabaseKeyException(String key){
//		synchronized (databaseKeyExcetion) {
//			log.info("entro a sincronizacion las propiedades");
			return databaseKeyExcetion.getProperty(key);
//		}
	}	



}
