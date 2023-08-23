package com.HandSolo.Asesorias.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.modelo.Pago;

@Repository
public interface PagoRepositorio extends CrudRepository<Pago, Integer> {

}
