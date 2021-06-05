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
import com.example.fenecoApp.services.ArquivoService;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivoResource {
	
	@Autowired
	private ArquivoService service;
	
	@GetMapping
	public Iterable<Arquivo> get() {
		return service.getArquivos();
	}
	
	@GetMapping("/{id}")
	public Optional<Arquivo> get(@PathVariable("id") Long id) {
		return service.getArquivosById(id);
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Arquivo> getArquivosByTipo(@PathVariable("tipo") String tipo) {
		return service.getArquivosByTipo(tipo);
	}
	
	@PostMapping
	public void post(@RequestBody Arquivo arquivo) {
		service.save(arquivo);
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Arquivo arquivo) {
		Arquivo a = service.update(arquivo, id);
		return "Arquivo atualizado";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Arquivo deletado";
	}
}
