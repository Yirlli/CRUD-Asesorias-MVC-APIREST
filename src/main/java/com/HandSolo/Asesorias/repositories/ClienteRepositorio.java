package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.domain.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer>{

}
