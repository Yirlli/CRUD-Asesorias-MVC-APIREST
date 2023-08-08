package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Profesional;

@Repository
public interface ProfesionalRepositorio extends CrudRepository<Profesional, Integer> {

}
