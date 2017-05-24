package com.leosoft.service;

import java.util.Date;

import javax.inject.Inject;

import com.leosoft.model.Movimiento;
import com.leosoft.repository.MovimientoRepository;
import com.leosoft.util.Transactional;

public class RegistrarMovimiento {

	@Inject
	private MovimientoRepository movimientoRepository;
	
	public RegistrarMovimiento(MovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}
	
	@Transactional
	public void guardar(Movimiento movimiento) throws NegociacionException {
		if(movimiento.getFechaPago() != null 
				&& movimiento.getFechaPago().after(new Date())){
			throw new NegociacionException("Fecha de pago no puede ser una futura");
		}
		
		this.movimientoRepository.adicionar(movimiento);
	}
}

