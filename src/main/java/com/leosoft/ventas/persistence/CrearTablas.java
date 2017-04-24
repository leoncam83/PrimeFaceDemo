package com.leosoft.ventas.persistence;

import javax.persistence.Persistence;

/**
 * 
 * @author leonc
 *
 */
public class CrearTablas {

	public static void main(String[] args) {
//		org.hibernate.ejb.HibernateEntityManager;
		Persistence.createEntityManagerFactory("PrimeFaceDemo");
	}
	
}
