package com.jasmine.erp.entities.clientes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jasmine.erp.entities.configuracion.Parametro;

@Entity
@Table(name = "citas")
public class Cita {
	
	/**
	 * Identificador de la cita
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Tipo de servicio a prestar
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "tipo_servicio",foreignKey = @ForeignKey(name = "fk_param_servicio"))
	private Parametro tipoServicio;
	/**
	 * Codigo que se genera para identificar la cita
	 */
	@Column(length = 10, nullable = false)
	private String codigo;
	/**
	 * Descripcion del servicio a prestar
	 */
	@Column(length = 100, nullable = false)
	private String descripcion;
	/**
	 * Fecha y hora del servicio
	 */
	@Column(name = "fecha_hora", nullable = false)
	private Date fechaHora;
	/**
	 * Sede de la cita
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_param_sede"))
	private Parametro sede;
	/**
	 * Cliente que solicita la cita
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente_id"))
	private Cliente cliente;
	
	//---------------------GETTER Y SETTER--------------------------------------------------------------
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the sede
	 */
	public Parametro getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(Parametro sede) {
		this.sede = sede;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * @return the tipoServicio
	 */
	public Parametro getTipoServicio() {
		return tipoServicio;
	}
	
	/**
	 * @param tipoServicio the tipoServicio to set
	 */
	public void setTipoServicio(Parametro tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
}