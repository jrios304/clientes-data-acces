package com.jasmine.erp.repositories.clientes.custom;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.jasmine.erp.entities.clientes.Cita;

public class CitaRepositoryImpl implements CitaRepositoryCustom{
	
	@PersistenceContext
	private EntityManager ent;

	@Override
	@Transactional
	public List<Cita> obtenerCitasFiltro(String codigo, Long idTipoServicio, Date fechaServicio, Long idSede,
			String nombreCliente) {
		Map<String, Object> params = new HashMap<>();

		String query = "select cita from Cita cita inner join Parametro servicio "
				+ "on servicio.id = cita.tipoServicio inner join Parametro sede "
				+ "on sede.id = cita.sede inner join Cliente cliente "
				+ "on cliente.id = cita.cliente where cita.id is not null ";
		
		if(!StringUtils.isEmpty(codigo)) {
			query += "and cita.codigo like :codigo ";
			params.put("codigo", codigo);
		}
		if(idTipoServicio != null) {
			query += "and servicio.id = :idServicio ";
			params.put("idServicio", idTipoServicio);
		}
		if(fechaServicio != null) {
			query += "and cita.fechaHora >= :fechaCita ";
			params.put("fechaCita", fechaServicio);
		}
		if(idSede != null) {
			query += "and sede.id = :idSede ";
			params.put("idSede", idSede);
		}
		if(!StringUtils.isEmpty(nombreCliente)) {
			query += "and cliente.nombre like :nombreCliente ";
			params.put("nombreCliente", nombreCliente);
		}
		
		query += "order by cita.fechaHora desc ";
		
		Query consulta = ent.createQuery(query);
		params.forEach((k,v) -> consulta.setParameter(k, v));
		
		@SuppressWarnings("unchecked")
		List<Cita> listaResultados = consulta.getResultList();
		return listaResultados;
	}
}