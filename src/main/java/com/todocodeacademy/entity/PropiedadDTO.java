package com.todocodeacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PropiedadDTO {
	private Long id_propiedad;
	private String direccion;
	private Double precioAlquiler;
	private String tipoPropiedad;
	private String inquilinoNombre;
	private String inquilinoApellido;
}
