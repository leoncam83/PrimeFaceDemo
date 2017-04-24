/**
 * 
 */
package com.leosoft.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

/**
 * @author Leonardo Castro Mestra
 *
 */
@ManagedBean
//@RequestScoped
//@ViewScoped
@SessionScoped
public class NombresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2192715786795450435L;
	private String nombre;
	private List<String> nombres = new ArrayList<>();
	
	private HtmlInputText nombreInput;
	private HtmlCommandButton agregarButton;
	
	public void agregar() {
		nombres.add(nombre);
		if(nombres.size() > 4) {
			nombreInput.setDisabled(true);
			agregarButton.setDisabled(true);
			agregarButton.setValue("No Puedes Agregar mas Valores");
		}
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}

	public HtmlInputText getNombreInput() {
		return nombreInput;
	}

	public void setNombreInput(HtmlInputText nombreInput) {
		this.nombreInput = nombreInput;
	}

	public HtmlCommandButton getAgregarButton() {
		return agregarButton;
	}

	public void setAgregarButton(HtmlCommandButton agregarButton) {
		this.agregarButton = agregarButton;
	}
	
	
}
