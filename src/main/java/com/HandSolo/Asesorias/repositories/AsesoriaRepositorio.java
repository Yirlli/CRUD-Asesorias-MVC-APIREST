package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Asesorias;

@Repository
public interface AsesoriaRepositorio extends CrudRepository<Asesorias, Integer>{

}
