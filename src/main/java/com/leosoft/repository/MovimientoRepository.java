/**
 * 
 */
package com.leosoft.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.leosoft.model.Movimiento;

/**
 * @author Leonardo Castro Mestra
 *
 */
public class MovimientoRepository {

	private  EntityManager manager;
	
	@Inject
	public MovimientoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Movimiento> todos() {
		TypedQuery<Movimiento> query = manager.createQuery("FROM Movimiento", Movimiento.class);
		return  query.getResultList();
	}

	public void adicionar(Movimiento movimiento) {
		EntityTransaction transaction = this.manager.getTransaction();
		
		transaction.begin();
		manager.persist(movimiento);		
		transaction.commit();
		
	}
		
}
