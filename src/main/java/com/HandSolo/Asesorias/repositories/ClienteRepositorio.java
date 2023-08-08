package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer>{

}
