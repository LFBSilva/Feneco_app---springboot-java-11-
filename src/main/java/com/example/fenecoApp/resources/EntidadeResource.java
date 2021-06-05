package com.example.fenecoApp.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fenecoApp.entities.Arquivo;
import com.example.fenecoApp.entities.Entidade;
import com.example.fenecoApp.services.EntidadeService;

@RestController
@RequestMapping("/api/entidades")
public class EntidadeResource {

	@Autowired
	private EntidadeService service;
	
	@GetMapping
	public Iterable<Entidade> get() {
		return service.getEntidade();
	}
	
	@GetMapping("/{id}")
	public Optional<Entidade> get(@PathVariable("id") Long id) {
		return service.getEntidadeById(id);
	}
	
	@GetMapping("/regiao/{regiao}")
	public Iterable<Entidade> getArquivosByTipo(@PathVariable("regiao") String regiao) {
		return service.getEntidadeByRegiao(regiao);
	}
	
	@PostMapping
	public void post(@RequestBody Entidade entidade) {
		service.save(entidade);
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Entidade entidade) {
		Entidade e = service.update(entidade, id);
		return "Arquivo atualizado";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Arquivo deletado";
	}
}
