/**
 * 
 */
package com.leosoft.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.leosoft.jpa.JPAUtil;
import com.leosoft.model.Movimiento;
import com.leosoft.repository.MovimientoRepository;

/**
 * @author leonc
 *
 */
@ManagedBean
@ViewScoped
public class ConsultaMovimientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6759575805883010854L;
	private List<Movimiento> movimientos;
	
	public void consultar(){
		EntityManager manager = JPAUtil.getManager();
		MovimientoRepository reposirtory = new MovimientoRepository(manager);
		movimientos = reposirtory.todos();
		manager.close();
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	
	
}
