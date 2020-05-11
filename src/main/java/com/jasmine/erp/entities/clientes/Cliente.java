package com.jasmine.erp.entities.clientes;

import java.time.LocalDate;

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
@Table(name = "clientes")
public class Cliente {
	
	/**
	 * Identificador del cliente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Nombre del cliente
	 */
	@Column(length = 30, nullable = false)
	private String nombre;
	/**
	 * Correo del cliente
	 */
	@Column(length = 30, nullable = false)
	private String email;
	/**
	 * Telefono del cliente
	 */
	@Column(length = 10, nullable = false)
	private String telefono;
	/**
	 * Ciudad en la que se situa el cliente
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_param_ciudad"))
	private Parametro ciudad;
	/**
	 * Fecha de creacion del cliente
	 */
	@Column(name = "fecha_creacion", nullable = false)
	private LocalDate fechaCreacion;
	
	//--------------GETTER Y SETTER-----------------------//

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the ciudad
	 */
	public Parametro getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Parametro ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
