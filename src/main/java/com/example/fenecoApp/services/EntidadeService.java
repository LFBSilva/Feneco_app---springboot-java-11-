package com.example.fenecoApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.fenecoApp.entities.Entidade;
import com.example.fenecoApp.repositories.EntidadeRepository;

@Service
public class EntidadeService {

	@Autowired
	private EntidadeRepository repository;

	public Iterable<Entidade> getEntidade() {
		return repository.findAll();
	}

	public Optional<Entidade> getEntidadeById(Long id) {
		return repository.findById(id);
	}

	public Iterable<Entidade> getEntidadeByRegiao(String regiao) {
		return repository.findByRegiao(regiao);
	}

	public Entidade save(Entidade entidade) {
		return repository.save(entidade);
	}

	public Entidade update(Entidade entidade, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");

		Optional<Entidade> optional = getEntidadeById(id);
		if(optional.isPresent()) {
			Entidade db = optional.get();
			db.setNome(entidade.getNome());
			db.setRegiao(entidade.getRegiao());
			db.setEndereco(entidade.getEndereco());

			System.out.println("Entidade i " + db.getId());
			
			repository.save(db);
			
			return db;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}

	public void delete(Long id) {
		Optional<Entidade> entidade = getEntidadeById(id);
		if (entidade.isPresent()) {
			repository.deleteById(id);
		}

	}
}
