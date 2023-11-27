package com.todocodeacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Plato {

	private Long id;
	private String nombre;
	private double precio;
	private String descripcion;
	

}
