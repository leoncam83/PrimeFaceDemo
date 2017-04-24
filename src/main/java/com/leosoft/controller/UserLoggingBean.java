/**
 * 
 */
package com.leosoft.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author leonc
 *
 */
@ManagedBean(name="userLoggingBean")
@RequestScoped
public class UserLoggingBean {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String validarUsuario() {		 
		if (username.equals("leoncam") && password.equals("15645805")) {
			System.out.println("ok");
			return "ok"; 
		} else  {
			System.out.println("no ok");
			return "badUsername";
		}
	}

}
