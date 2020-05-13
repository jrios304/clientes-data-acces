package com.jasmine.erp.repositories.clientes.custom;

import java.time.LocalDate;
import java.util.List;

import com.jasmine.erp.entities.clientes.Cliente;

public interface ClienteRepositoryCustom {
	
	/**
	 * Permite buscar la lista de clientes de acuerdo a los filtros ingresados
	 * @param nombre
	 * @param email
	 * @param telefono
	 * @param idCiudad
	 * @param fechaCreacion
	 * @return
	 */
	List<Cliente> obtenerClientesFiltro(String nombre, String email, String telefono, Long idCiudad, LocalDate fechaCreacion);
}
