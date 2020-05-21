package com.jasmine.erp.repositories.clientes.custom;

import java.util.Date;
import java.util.List;

import com.jasmine.erp.entities.clientes.Cita;

public interface CitaRepositoryCustom {
	
	/**
	 * Permite buscar la lista de citas de acuerdo a los filtros ingresados
	 * @param codigo
	 * @param idTipoServicio
	 * @param fechaServicio
	 * @param idSede
	 * @param nombreCliente
	 * @return
	 */
	List<Cita> obtenerCitasFiltro(String codigo, Long idTipoServicio, Date fechaServicio, 
			Long idSede, String nombreCliente);
}
