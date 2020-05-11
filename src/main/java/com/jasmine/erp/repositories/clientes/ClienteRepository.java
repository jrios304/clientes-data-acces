package com.jasmine.erp.repositories.clientes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasmine.erp.entities.clientes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
}
