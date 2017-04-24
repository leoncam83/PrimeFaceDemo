/**
 * 
 */
package com.leosoft.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.leosoft.jpa.JPAUtil;
import com.leosoft.model.Movimiento;
import com.leosoft.model.Persona;
import com.leosoft.model.TipoMovimiento;
import com.leosoft.repository.MovimientoRepository;
import com.leosoft.repository.PersonaRepository;
import com.leosoft.service.NegociacionException;
import com.leosoft.service.RegistrarMovimiento;

/**
 * @author leonc
 *
 */
@ManagedBean
@ViewScoped
public class RegistroMovimientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3387640789668919153L;
	private List<Persona> todasPersonas;
	private Movimiento movimiento = new Movimiento();
	private TipoMovimiento[] tipoMovimientos = TipoMovimiento.values(); 
	
	public void prepararRegistro(){
		EntityManager manager = JPAUtil.getManager();

		try {
			PersonaRepository personaRepository = new PersonaRepository(manager);
			todasPersonas = personaRepository.todos();
		} finally {			
			manager.close();
		}
	}
	
	public void guardar() {
		EntityManager manager = JPAUtil.getManager();
		EntityTransaction transaction = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		try {
			
			transaction.begin();
			RegistrarMovimiento registrarMovimiento = new RegistrarMovimiento(new MovimientoRepository(manager));
			registrarMovimiento.guardar(movimiento);
			
	
			transaction.commit();
			context.addMessage(null, new FacesMessage("Movimiento grabado con exito!"));
			this.movimiento = new Movimiento();			
						
		} catch (NegociacionException e) {
			transaction.rollback();
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
		} finally {
			manager.close();
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
