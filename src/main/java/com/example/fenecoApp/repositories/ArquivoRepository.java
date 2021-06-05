package com.example.fenecoApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.fenecoApp.entities.Arquivo;

public interface ArquivoRepository extends CrudRepository<Arquivo, Long> {

	Iterable<Arquivo> findByTipo(String tipo);

}
