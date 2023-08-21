package com.HandSolo.Asesorias.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.VisitaTerreno;

@Repository
public interface VisitaRepository extends CrudRepository <VisitaTerreno, Integer> {

}
