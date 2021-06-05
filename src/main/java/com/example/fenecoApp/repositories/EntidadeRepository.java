package com.example.fenecoApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.fenecoApp.entities.Entidade;

public interface EntidadeRepository extends CrudRepository<Entidade, Long> {

	Iterable<Entidade> findByRegiao(String regiao);

}
