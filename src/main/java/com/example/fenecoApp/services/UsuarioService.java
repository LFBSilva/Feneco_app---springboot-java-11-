package com.example.fenecoApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.fenecoApp.entities.Usuario;
import com.example.fenecoApp.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Iterable<Usuario> getUsuario() {
		return repository.findAll();
	}

	public Optional<Usuario> getUsuarioById(Long id) {
		return repository.findById(id);
	}

	public Iterable<Usuario> getUsuarioByCargo(String cargo) {
		return repository.findByCargo(cargo);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario update(Usuario usuario, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");

		Optional<Usuario> optional = getUsuarioById(id);
		if (optional.isPresent()) {
			Usuario db = optional.get();
			db.setNome(usuario.getNome());
			db.setEmail(usuario.getEmail());
			db.setSenha(usuario.getSenha());
			db.setCargo(usuario.getCargo());
			System.out.println("Usuário id " + db.getId());

			repository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}
	
	public void delete(Long id) {
		Optional<Usuario> usuario = getUsuarioById(id);
		if(usuario.isPresent()) {
			repository.deleteById(id);
		}
		
	}

}
