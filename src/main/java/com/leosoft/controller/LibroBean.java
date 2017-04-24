package com.leosoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.leosoft.model.Libros;

@ManagedBean
@ViewScoped
public class LibroBean {

	private List<Libros> libros; 
	private Libros nuevoLibro;
	
	public LibroBean() {
		
		this.nuevoLibro = new Libros();
		
		this.libros = new ArrayList<Libros>();		
		this.libros.add(new Libros("Java SE 7", "Marlon Fuente"));
		this.libros.add(new Libros("Ruby and Rails", "Dioniso Paredes"));
		this.libros.add(new Libros("Test Driven Develoment", "Angel Nuñez"));
		this.libros.add(new Libros("Django for Dummies", "Joe Perez"));
		this.libros.add(new Libros("El alquista", "Cohelo"));
		
	}
	
	public void agregar() {
		this.libros.add(nuevoLibro);
		this.nuevoLibro =new Libros();
	}

	public List<Libros> getLibros() {
		return libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}

	public Libros getNuevoLibro() {
		return nuevoLibro;
	}

	public void setNuevoLibro(Libros nuevoLibro) {
		this.nuevoLibro = nuevoLibro;
	}
		
	
}
