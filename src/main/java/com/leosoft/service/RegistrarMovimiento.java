package com.leosoft.service;

import java.util.Date;

import com.leosoft.model.Movimiento;
import com.leosoft.repository.MovimientoRepository;

public class RegistrarMovimiento {

	MovimientoRepository movimientoRepository;
	
	public RegistrarMovimiento(MovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}
	
	public void guardar(Movimiento movimiento) throws NegociacionException {
		if(movimiento.getFechaPago() != null 
				&& movimiento.getFechaPago().after(new Date())){
			throw new NegociacionException("Fecha de pago no puede ser una futura");
		}
		
		this.movimientoRepository.adicionar(movimiento);
	}
}

