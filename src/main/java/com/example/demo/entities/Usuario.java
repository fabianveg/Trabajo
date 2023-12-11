package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nick;
	
	private String name;
	
	private String pass;
	
	
	@OneToMany
	private List<Carro> carros = new ArrayList<>();


	public Usuario(String nick, String name, String pass) {
		super();
		this.nick = nick;
		this.name = name;
		this.pass = pass;
	}
	
	
}

