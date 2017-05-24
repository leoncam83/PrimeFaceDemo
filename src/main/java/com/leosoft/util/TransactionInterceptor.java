/**
 * 
 */
package com.leosoft.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author leonc
 *
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457155341175102264L;
	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		boolean creador = false; 
		try {
			
			if(!transaction.isActive()) {
				transaction.begin();
				transaction.rollback();
				
				transaction.begin();
				creador = true;
			}
			
			return context.proceed();
		}catch (Exception e) {
			if(transaction != null && creador) {
				transaction.rollback();
			}
			
			throw e;
		} finally {
			if(transaction != null && transaction.isActive() && creador) {
				transaction.commit();
			}
		}
	}
	
}
