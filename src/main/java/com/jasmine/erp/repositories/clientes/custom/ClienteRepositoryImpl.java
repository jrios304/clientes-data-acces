package com.jasmine.erp.repositories.clientes.custom;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.jasmine.erp.entities.clientes.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom{
	
	@PersistenceContext
	private EntityManager ent;

	@Override
	@Transactional
	public List<Cliente> obtenerClientesFiltro(String nombre, String email, String telefono, Long idCiudad,
			LocalDate fechaCreacion) {
		Map<String, Object> params = new HashMap<>();
		
		String query = "select cliente from Cliente cliente inner join Parametro ciudad "
				+ "on ciudad.id = cliente.ciudad where cliente.id is not null ";
		
		if(!StringUtils.isEmpty(nombre)) {
			query += "and cliente.nombre like :nombre ";
			params.put("nombre", nombre);
		}
		if(!StringUtils.isEmpty(email)) {
			query += "and cliente.email like :email ";
			params.put("email", email);
		}
		if(!StringUtils.isEmpty(telefono)) {
			query += "and cliente.telefono like :telefono ";
			params.put("telefono", telefono);
		}
		if(idCiudad != null) {
			query += "and cliente.ciudad.id = :ciudad ";
			params.put("ciudad", idCiudad);
		}
		if(fechaCreacion != null) {
			query += "and cliente.fechaCreacion = :fechaCreacion ";
			params.put("fechaCreacion", fechaCreacion);
		}
		
		query += "order by cliente.fechaCreacion asc ";
		
		Query consulta = ent.createQuery(query);
		params.forEach((k,v) -> consulta.setParameter(k, v));
		
		@SuppressWarnings("unchecked")
		List<Cliente> listaResultados = consulta.getResultList();
		return listaResultados;
	}
}