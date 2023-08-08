package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Contacto;

@Repository
public interface ContactoRepositorio extends CrudRepository<Contacto, Integer> {

}
