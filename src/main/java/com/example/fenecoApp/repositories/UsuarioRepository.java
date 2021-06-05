package com.example.fenecoApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.fenecoApp.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Iterable<Usuario> findByCargo(String cargo);

}
