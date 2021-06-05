package com.example.fenecoApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.fenecoApp.entities.Arquivo;
import com.example.fenecoApp.repositories.ArquivoRepository;

@Service
public class ArquivoService {
	
	@Autowired
	private ArquivoRepository repository;
	
	public Iterable<Arquivo> getArquivos(){
		return repository.findAll();
	}

	public Optional<Arquivo> getArquivosById(Long id) {
		return repository.findById(id);
	}

	public Iterable<Arquivo> getArquivosByTipo(String tipo) {
		return repository.findByTipo(tipo);
	}

	public Arquivo save(Arquivo arquivo) {
		return repository.save(arquivo);
	}

	public Arquivo update(Arquivo arquivo, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		
		Optional<Arquivo> optional = getArquivosById(id);
		if(optional.isPresent()) {
			Arquivo db = optional.get();
			db.setNome(arquivo.getNome());
			db.setDescricao(arquivo.getDescricao());
			db.setTipo(arquivo.getTipo());
			db.setDataEnvio(arquivo.getDataEnvio());
			System.out.println("Arquivo id " + db.getId());
			
			repository.save(db);
			
			return db;
		}else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}

	 public void delete(Long id) {
		Optional<Arquivo> arquivo = getArquivosById(id);
		if(arquivo.isPresent()) {
			repository.deleteById(id);
		}
		
	}
}
