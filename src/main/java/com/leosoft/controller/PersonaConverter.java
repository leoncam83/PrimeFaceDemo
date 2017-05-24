package com.leosoft.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.leosoft.model.Persona;
import com.leosoft.repository.PersonaRepository;
import com.leosoft.service.CDILocator;

@FacesConverter(forClass = Persona.class, value="personaValue")
public class PersonaConverter implements Converter {

	private PersonaRepository personaRepository;   

	public PersonaConverter() {
		personaRepository = CDILocator.getBean(PersonaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Persona retorno = null;

		if(value != null) { 
			retorno = personaRepository.porId(new Long(value));
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
