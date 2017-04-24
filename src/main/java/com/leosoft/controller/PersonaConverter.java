package com.leosoft.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.leosoft.jpa.JPAUtil;
import com.leosoft.model.Persona;
import com.leosoft.repository.PersonaRepository;

@FacesConverter(forClass = Persona.class, value="personaValue")
public class PersonaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Persona retorno = null;
		EntityManager manager = JPAUtil.getManager();
		try {
			
			if(value != null) { 
				PersonaRepository repository = new PersonaRepository(manager);
				retorno = repository.porId(new Long(value));
			}
			
		} finally { 
			manager.close();
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(value != null) {
			return ((Persona) value).getId().toString();
		}
		
		return null;
	}

}
