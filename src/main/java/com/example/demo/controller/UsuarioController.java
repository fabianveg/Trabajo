package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Carro;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.carroRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;
	@Autowired
	carroRepository carroRepo;
	
	@GetMapping("/listar")
	public List<Usuario> getUsuarioAll() {

		List<Usuario> usuarios = repo.findAll();
		return usuarios;
	}

	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Integer id) {

		Optional<Usuario> Usuario = repo.findById(id);

		if (Usuario.isEmpty()) {
			return null;
		}
		return Usuario.get();
	}

	@PostMapping("/crear")
	public Usuario create(@RequestBody Usuario Usuario) {

		repo.save(Usuario);

		return Usuario;
	}

	@DeleteMapping("/{id}")
	public Usuario deleteUsuariobyID(@PathVariable Integer id) {

		

		Optional<Usuario> Usuario = repo.findById(id);

		if (Usuario.isPresent()) {
			Usuario UsuarioReturn = Usuario.get();
			repo.deleteById(id);
			return UsuarioReturn;
		}
		return null;

	}

	@PostMapping("/agregarCarro/{id}")
	public void agregarCarro(@RequestBody Carro carro, @PathVariable Integer id) {
		Usuario user = repo.findById(id).get();
		List<Carro> carros = new ArrayList<>();
	
		
		if(repo.findById(id).get().getCarros()==null){
			carros.add(carro);
			user.setCarros(carros);
		}else {
			user.getCarros().add(carro);
		}
		if(carroRepo.findById(carro.getPlaca())!=null) {
			carroRepo.save(carro);
		}
		repo.save(user);
		
	}
}
