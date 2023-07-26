package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.domain.Capacitacion;


@Repository
public interface CapacitacionRepositorio extends CrudRepository<Capacitacion, Integer>{

}
