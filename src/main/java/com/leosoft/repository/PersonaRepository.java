/**
 * 
 */
package com.leosoft.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.leosoft.model.Persona;

/**
 * @author leonc
 *
 */
public class PersonaRepository {

private  EntityManager manager;
	
	public PersonaRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Persona> todos() {
		TypedQuery<Persona> query = manager.createQuery("FROM Persona", Persona.class);
		return  query.getResultList();
	}

	public Persona porId(Long id) {
		TypedQuery<Persona> query = manager.createQuery("FROM Persona p WHERE p.id = :id", Persona.class);
		query.setParameter("id", id);
		return  query.getSingleResult();
	}
}
