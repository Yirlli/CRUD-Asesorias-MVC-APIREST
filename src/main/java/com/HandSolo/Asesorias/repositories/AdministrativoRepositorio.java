package com.HandSolo.Asesorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.domain.Administrativo;

@Repository
public interface AdministrativoRepositorio extends CrudRepository<Administrativo, Integer> {

}
