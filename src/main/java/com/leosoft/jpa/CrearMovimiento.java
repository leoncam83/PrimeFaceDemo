/**
 * 
 */
package com.leosoft.jpa;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.leosoft.model.Movimiento;
import com.leosoft.model.Persona;
import com.leosoft.model.TipoMovimiento;

/**
 * @author leonc
 *
 */
public class CrearMovimiento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		try {
			
			Calendar fechaVencimiento1 = Calendar.getInstance();
			fechaVencimiento1.set(2016, 1, 5);
			
			Calendar fechaVencimiento2 = Calendar.getInstance();
			fechaVencimiento2.set(2016, 5, 15);
			
			Persona cliente = new Persona();
			cliente.setNombres("INVERSIONES OCHOA");
			Persona proveedor = new Persona();
			proveedor.setNombres("ACEROS AREQUIPA");
			
			Movimiento movimiento1 = new Movimiento();
			movimiento1.setDescripcion("Compra de Barras de Acero");
			movimiento1.setPersona(cliente);
			movimiento1.setFechaVencimiento(fechaVencimiento1.getTime());
			movimiento1.setFechaPago(fechaVencimiento1.getTime());
			movimiento1.setValor(new BigDecimal(103.000));
			movimiento1.setTipoMovimiento(TipoMovimiento.COMPRAS);
			
			Movimiento movimiento2 = new Movimiento();
			movimiento2.setDescripcion("Compra de plancho de Acero");
			movimiento2.setPersona(cliente);
			movimiento2.setFechaVencimiento(fechaVencimiento1.getTime());
			movimiento2.setFechaPago(fechaVencimiento1.getTime());
			movimiento2.setValor(new BigDecimal(15.000));
			movimiento2.setTipoMovimiento(TipoMovimiento.COMPRAS);
			
			Movimiento movimiento3 = new Movimiento();
			movimiento3.setDescripcion("ventar de plancho de Acero");
			movimiento3.setPersona(proveedor);
			movimiento3.setFechaVencimiento(fechaVencimiento1.getTime());
			movimiento3.setFechaPago(fechaVencimiento1.getTime());
			movimiento3.setValor(new BigDecimal(68.000));
			movimiento3.setTipoMovimiento(TipoMovimiento.VENTAS);
			
			manager.persist(cliente);
			manager.persist(proveedor);
			manager.persist(movimiento1);
			manager.persist(movimiento2);
			manager.persist(movimiento3);
			
			transaction.commit();
			
			
		} catch (Exception e) {
			e.getStackTrace();
		
		}finally {
			if(manager!= null && manager.isOpen()) {
				manager.close();
			}
		}
		
	}

}
