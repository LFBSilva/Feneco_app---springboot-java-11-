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

import com.example.fenecoApp.entities.Usuario;
import com.example.fenecoApp.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public Iterable<Usuario> get() {
		return service.getUsuario();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> get(@PathVariable("id") Long id) {
		return service.getUsuarioById(id);
	}
	
	@GetMapping("/cargo/{cargo}")
	public Iterable<Usuario> getArquivosByCargo(@PathVariable("cargo") String cargo) {
		return service.getUsuarioByCargo(cargo);
	}
	
	@PostMapping
	public void post(@RequestBody Usuario usuario) {
		service.save(usuario);
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		Usuario u = service.update(usuario, id);
		return "Arquivo atualizado";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Arquivo deletado";
	}
}
