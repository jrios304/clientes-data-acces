package com.jasmine.erp.repositories.clientes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jasmine.erp.entities.clientes.Cita;
import com.jasmine.erp.entities.configuracion.Parametro;
import com.jasmine.erp.repositories.clientes.custom.CitaRepositoryCustom;

/**
 * Repositorio para comunicacion y actualizacion de la tabla Cita
 * @author jrios
 *
 */
public interface CitaRepository  extends JpaRepository<Cita, Long>, CitaRepositoryCustom{

	/**
	 * Consultas para las listas de los filtros
	 * @param valor
	 * @return
	 */
	@Query("select distinct c.codigo from Cita c where c.codigo like %?1%")
	List<String> obtenerListaCodigoFiltro(String valor);
	@Query("select distinct p from Cita c inner join Parametro p on p.id = c.tipoServicio")
	List<Parametro> obtenerListaTipoServicioFiltro();
	@Query("select distinct p from Cita c inner join Parametro p on p.id = c.sede")
	List<Parametro> obtenerListaSedeFiltro();
	@Query("select distinct cliente.nombre from Cita c inner join Cliente cliente on cliente.id = c.cliente"
			+ " where cliente.nombre like %?1%")
	List<String> obtenerListaClienteFiltro(String valor);
	
	/**
	 * Obtiene las listas que estan relacionadas a un cliente
	 * @param idCliente, id del cliente a buscar
	 * @return
	 */
	@Query("select c from Cita c where c.cliente.id = ?1")
	List<Cita> obtenerCitasCliente(Long idCliente);
}
