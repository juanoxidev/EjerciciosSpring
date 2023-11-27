package com.todocodeacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Inquilino {
	private Long id_inquilino;
	private String dni;
	private String nombre;
	private String apellido;
	private String profesion;
}
