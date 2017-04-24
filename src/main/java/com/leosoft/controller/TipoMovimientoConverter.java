/**
 * 
 */
package com.leosoft.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.leosoft.model.TipoMovimiento;

/**
 * @author Leonardo Castro Mestras
 *
 */
@FacesConverter(forClass = TipoMovimiento.class, value="tipoMovimientoValue")
public class TipoMovimientoConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if(value != null) {
			return TipoMovimiento.valueOf(value);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		String valor = null;		
		if(value != null) {
			try {
				valor = ((TipoMovimiento) value).name();
			}catch (Exception e) {
				e.getStackTrace();
			}
		} 

		return valor;
	}

}
