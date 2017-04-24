/**
 * 
 */
package com.leosoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * @author leonc
 *
 */
@ManagedBean
public class MiCiudadBean {

	private String ciudadNatal;
	private List<String> totasCiudades;
	
	public MiCiudadBean() {
		this.totasCiudades = new ArrayList<String>();
		this.totasCiudades.add("Montería");
		this.totasCiudades.add("Bello");
		this.totasCiudades.add("Medellin");
		this.totasCiudades.add("Cienaga de Oro");
		this.totasCiudades.add("Cereté");
		this.totasCiudades.add("Sincelejo");
	}

	public String getCiudadNatal() {
		return ciudadNatal;
	}

	public void setCiudadNatal(String ciudadNatal) {
		this.ciudadNatal = ciudadNatal;
	}

	public List<String> getTotasCiudades() {
		return totasCiudades;
	}

	public void setTotasCiudades(List<String> totasCiudades) {
		this.totasCiudades = totasCiudades;
	}
	
}
