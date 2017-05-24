/**
 * 
 */
package com.leosoft.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.leosoft.model.Movimiento;
import com.leosoft.repository.MovimientoRepository;
import com.leosoft.util.JPAUtil;

/**
 * @author leonc
 *
 */
@Named
@ViewScoped
public class ConsultaMovimientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6759575805883010854L;
	
	@Inject
	private MovimientoRepository movimientoRepository;
	
	private List<Movimiento> movimientos;
	
	public void consultar(){		
		movimientos = movimientoRepository.todos();		
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	
	
}
