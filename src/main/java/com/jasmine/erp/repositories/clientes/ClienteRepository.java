package com.jasmine.erp.repositories.clientes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jasmine.erp.entities.clientes.Cliente;
import com.jasmine.erp.entities.configuracion.Parametro;
import com.jasmine.erp.repositories.clientes.custom.ClienteRepositoryCustom;

/**
 * Repositorio para comunicacion y actualizacion de la tabla Cliente
 * @author jrios
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom{

	/**
	 * Consultas para el listado de filtros
	 * @return
	 */
	@Query("select distinct cliente.nombre from Cliente cliente where cliente.nombre like %?1%")
	List<String> obtenerListaNombresFiltro(String valor);
	@Query("select distinct cliente.email from Cliente cliente where cliente.email like %?1%")
	List<String> obtenerListaCorreosFiltro(String valor);
	@Query("select distinct cliente.telefono from Cliente cliente where cliente.telefono like %?1%")
	List<String> obtenerListaTelefonosFiltro(String valor);
	@Query("select distinct param from Cliente cliente inner join Parametro param on param.id = cliente.ciudad")
	List<Parametro> obtenerListaCiudadesFiltro();
	
	/**
	 * Permite el uso de autocompletar para clientes de acuerdo a su nombre
	 * @param valor
	 * @return
	 */
	@Query("select e from Cliente e where e.nombre like %?1%")
	List<Cliente> obtenerClientesAutocomplete(String valor);
}
