/**
 * 
 */
package com.leosoft.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.leosoft.model.Movimiento;
import com.leosoft.model.Persona;
import com.leosoft.model.TipoMovimiento;
import com.leosoft.repository.PersonaRepository;
import com.leosoft.service.NegociacionException;
import com.leosoft.service.RegistrarMovimiento;

/**
 * @author leonc
 *
 */
@Named
@ViewScoped
public class RegistroMovimientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3387640789668919153L;

	@Inject
	private RegistrarMovimiento registrarMovimiento;

	@Inject 
	private PersonaRepository personaRepository;

	private List<Persona> todasPersonas;
	private Movimiento movimiento = new Movimiento();
	private TipoMovimiento[] tipoMovimientos = TipoMovimiento.values(); 

	public void prepararRegistro(){
		this.todasPersonas = this.personaRepository.todos();
	}

	public void guardar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			registrarMovimiento.guardar(movimiento);

			context.addMessage(null, new FacesMessage("Movimiento grabado con exito!"));
			this.movimiento = new Movimiento();			

		} catch (NegociacionException e) {			
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
		} 
	}

	public List<Persona> getTodasPersonas() {
		return todasPersonas;
	}

	public void setTodasPersonas(List<Persona> todasPersonas) {
		this.todasPersonas = todasPersonas;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public TipoMovimiento[] getTipoMovimientos() {
		return tipoMovimientos;
	}

	public void setTipoMovimientos(TipoMovimiento[] tipoMovimientos) {
		this.tipoMovimientos = tipoMovimientos;
	}

	public void fechaVencimientoModificado(AjaxBehaviorEvent event) {
		if(this.movimiento.getFechaPago() == null) {
			System.out.println(this.movimiento.getFechaVencimiento());
			this.movimiento.setFechaPago(this.movimiento.getFechaVencimiento());
		}
	}

}
