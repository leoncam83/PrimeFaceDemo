package com.leosoft.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ComponenteBean {

	private String equipoFavorito;
	private String[] equiposFavoritos; 
	private Integer[] lenguajes; 
	
	public void registrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Efectuado", 
				"Cliente Leonardo registrado con existo");
		
		context.addMessage(null, message);
	}

	public String getEquipoFavorito() {
		return equipoFavorito;
	}

	public void setEquipoFavorito(String equipoFavorito) {
		this.equipoFavorito = equipoFavorito;
	}

	public String[] getEquiposFavoritos() {
		return equiposFavoritos;
	}

	public void setEquiposFavoritos(String[] equiposFavoritos) {
		this.equiposFavoritos = equiposFavoritos;
	}

	public Integer[] getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(Integer[] lenguajes) {
		this.lenguajes = lenguajes;
	}
	
	
}
