package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity

public class Carro implements Serializable {

	
	@Id
	private String placa;
	
	private String color;
	
	private String modelo;
	
	private String marca;
	
	private int cilindraje;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Carro(String placa, String color, String modelo, String marca, int cilindraje) {
		
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindraje = cilindraje;
	}

	public Carro() {
	
	}
	
	
	
	
}
