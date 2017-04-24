package com.leosoft.model;

import java.io.Serializable;

public class Libros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8093599944120518058L;
	
	private String titulo;
	private String autor;
	
	public Libros() {
	}
	
	public Libros(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
}
