package com.HandSolo.Asesorias.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HandSolo.Asesorias.domain.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}
