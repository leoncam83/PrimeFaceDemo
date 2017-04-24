/**
 * 
 */
package com.leosoft.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Leonardo Castro Mestra
 *
 */
@Entity
public class Movimiento {

	@Id
	@SequenceGenerator(name="movimiento_seq", sequenceName="movimiento_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movimiento_seq")
	private Long id;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name="persona_id", referencedColumnName="id")
	private Persona persona;
	
	@NotEmpty
	@Size(max=60)
	@Column(length=60, nullable=false)
	private String descripcion;
	
	@NotNull
	@DecimalMin("0")
	@Column(precision=10, scale=2, nullable=false)
	private BigDecimal valor;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_movimiento", length=100, nullable=false)
	private TipoMovimiento tipoMovimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento", nullable=false)
	private Date fechaVencimiento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago", nullable=false)
	private Date fechaPago;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Movimiento))
			return false;
		Movimiento other = (Movimiento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
