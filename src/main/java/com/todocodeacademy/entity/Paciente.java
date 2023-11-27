package com.todocodeacademy.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Paciente {
	private Long id;
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fnacimiento;

}
