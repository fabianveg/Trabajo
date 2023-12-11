package com.example.demo.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.carroRepository;
import com.example.demo.entities.Carro;



@RestController
@RequestMapping("/carro")
public class carroController {

	@Autowired
	carroRepository carroRepository;
	
	

	@GetMapping
	public List<Carro> getCarroAll() {

		List<Carro> carros = carroRepository.findAll();
	
		return carros;
	}

	@GetMapping("/{placa}")
	public Carro getCarro(@PathVariable String placa) {

		Optional<Carro> carro = carroRepository.findById(placa);

		if (carro.isEmpty()) {
			return null;
		}
		return carro.get();
	}

	@PostMapping("/crear")
	public Carro create(@RequestBody Carro carro) {

		carroRepository.save(carro);

		return carro;
	}

	@PostMapping("/actualizar/{placa}")
	public Carro putCarroByID(@PathVariable String placa, @RequestBody Carro carro) {

		Optional<Carro> carroCurrent = carroRepository.findById(placa);

		if (carroCurrent.isPresent()) {
			Carro carroReturn = carroCurrent.get();
			carroReturn.setCilindraje(carro.getCilindraje());
			carroReturn.setColor(carro.getColor());
			carroReturn.setMarca(carro.getMarca());
			carroReturn.setModelo(carro.getModelo());

			carroRepository.save(carro);
			return carroReturn;
		}
		return null;

	}

	@DeleteMapping("/{placa}")
	public Carro deleteCarrobyID(@PathVariable String placa) {

		Optional<Carro> carro = carroRepository.findById(placa);

		if (carro.isPresent()) {
			Carro carroReturn = carro.get();
			carroRepository.deleteById(placa);
			return carroReturn;
		}
		return null;

	}
}
