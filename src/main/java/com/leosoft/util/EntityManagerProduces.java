/**
 * 
 */
package com.leosoft.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author leonc
 *
 */
@ApplicationScoped
public class EntityManagerProduces {

	private EntityManagerFactory factory;
	
	public EntityManagerProduces() {
		this.factory = Persistence.createEntityManagerFactory("PrimeFaceDemo");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	
	public void closeEntityManager(@Disposes EntityManager  manager) {
		manager.close();
	}
	
}
