package com.todocodeacademy.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.entity.Inquilino;
import com.todocodeacademy.entity.Paciente;
import com.todocodeacademy.entity.Plato;
import com.todocodeacademy.entity.Propiedad;
import com.todocodeacademy.entity.PropiedadDTO;

@RestController
public class ApplicacionController {

	// Ejercicio 1
	@GetMapping("/plato/traer/{idPLato}")
	public ResponseEntity<?> traerPlato(@PathVariable Long idPLato) {
		int i = 0;
		Plato platoBuscado = null;
		List<Plato> listaDePlatos = new ArrayList<Plato>();
		listaDePlatos.add(new Plato(1L, "Arroz con Atun", 1200, "Arroz con Atun"));
		listaDePlatos.add(new Plato(2L, "Pizza M", 2000, "Pizza mediana"));
		listaDePlatos.add(new Plato(3L, "Pizza G", 3500, "Pizza grande"));
		listaDePlatos.add(new Plato(5L, "Risotto c/ Hongos", 3000, "Risotto especialidad"));
		listaDePlatos.add(new Plato(6L, "Milanesa c/pure", 1200, "Milanesa de peceto con pure"));
		while (platoBuscado == null && i < listaDePlatos.size()) {
			if (listaDePlatos.get(i).getId() == idPLato) {
				platoBuscado = listaDePlatos.get(i);
			} else {
				i++;
			}
		}

		if (platoBuscado == null) {
			return new ResponseEntity<String>("N de plato no existe", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Plato>(platoBuscado, HttpStatus.OK);
		}

	}

	// Ejercicio 2
	@GetMapping("/paciente/traer")
	@ResponseBody
	public List<Paciente> traerPacientes(){
		List<Paciente> listaDePacientes = new ArrayList<Paciente>();
		// LocalDate date = LocalDate.of(2020, 1, 8); 8 de Enero de 2020
		listaDePacientes.add(new Paciente(1L, "12345678", "Juan", "Gómez", LocalDate.of(1990, 5, 15)));
		listaDePacientes.add(new Paciente(2L, "98765432", "María", "Rodríguez", LocalDate.of(2013, 8, 22)));
		listaDePacientes.add(new Paciente(3L, "56789012", "Carlos", "Fernández", LocalDate.of(1995, 2, 8)));
		listaDePacientes.add(new Paciente(4L, "34567890", "Ana", "López", LocalDate.of(1980, 11, 30)));
		listaDePacientes.add(new Paciente(5L, "87654321", "Pedro", "Pérez", LocalDate.of(2006, 7, 3)));
		listaDePacientes.add(new Paciente(6L, "23456789", "Laura", "Martínez", LocalDate.of(2009, 4, 18)));
		listaDePacientes.add(new Paciente(7L, "45678901", "Diego", "Sánchez", LocalDate.of(2010, 9, 12)));
		listaDePacientes.add(new Paciente(8L, "89012345", "Elena", "Gómez", LocalDate.of(1982, 6, 25)));
		listaDePacientes.add(new Paciente(9L, "67890123", "Sofía", "Rodríguez", LocalDate.of(1996, 3, 9)));
		listaDePacientes.add(new Paciente(10L, "11223344", "Javier", "Fernández", LocalDate.of(1989, 1, 5)));
		return listaDePacientes;
	}

	@GetMapping("/paciente/traer/menores")
	@ResponseBody
	public List<Paciente> traerPacientesMenores() {
		LocalDate hoy = LocalDate.now();
		List<Paciente> listaDePacientes = new ArrayList<Paciente>();
		// LocalDate date = LocalDate.of(2020, 1, 8); 8 de Enero de 2020
		listaDePacientes.add(new Paciente(1L, "12345678", "Juan", "Gómez", LocalDate.of(1990, 5, 15)));
		listaDePacientes.add(new Paciente(2L, "98765432", "María", "Rodríguez", LocalDate.of(2013, 8, 22)));
		listaDePacientes.add(new Paciente(3L, "56789012", "Carlos", "Fernández", LocalDate.of(1995, 2, 8)));
		listaDePacientes.add(new Paciente(4L, "34567890", "Ana", "López", LocalDate.of(1980, 11, 30)));
		listaDePacientes.add(new Paciente(5L, "87654321", "Pedro", "Pérez", LocalDate.of(2006, 7, 3)));
		listaDePacientes.add(new Paciente(6L, "23456789", "Laura", "Martínez", LocalDate.of(2009, 4, 18)));
		listaDePacientes.add(new Paciente(7L, "45678901", "Diego", "Sánchez", LocalDate.of(2010, 9, 12)));
		listaDePacientes.add(new Paciente(8L, "89012345", "Elena", "Gómez", LocalDate.of(1982, 6, 25)));
		listaDePacientes.add(new Paciente(9L, "67890123", "Sofía", "Rodríguez", LocalDate.of(1996, 3, 9)));
		listaDePacientes.add(new Paciente(10L, "11223344", "Javier", "Fernández", LocalDate.of(1989, 1, 5)));
		List<Paciente> listaDePacientesMenores = new ArrayList<Paciente>();
		for (Paciente paciente : listaDePacientes) {
			/*
			 * Period.between(hoy, paciente.getFnacimiento()): Calcula el periodo de tiempo
			 * entre hoy y la fecha de nacimiento del paciente. .getYears(): Obtiene la
			 * diferencia entre las dos fechas representada en años.
			 */
			System.out.println(Period.between(paciente.getFnacimiento(), hoy).getYears());
			if (Period.between(paciente.getFnacimiento(), hoy).getYears() < 18) {
				listaDePacientesMenores.add(paciente);
			}
		}

		return listaDePacientesMenores;

	}
	
	// DTO 
	@GetMapping("/propiedad/{id}")
	@ResponseBody
	public PropiedadDTO devolverPropiedad(@PathVariable Long id) {
		// a traves del id buscamos la propiedad
		// traemos al inquilino asociado a esa propiedad
		
		Propiedad prop = new Propiedad(1L, "Avenida Siempre Viva 123", 300.0, 5000.0, "Casa");
		Inquilino inqui = new Inquilino(1L, "12341234123", "Homero", "Simpson", "Empleado de la planta nuclear");
		PropiedadDTO propiedadDatos = new PropiedadDTO();
		propiedadDatos.setDireccion(prop.getDireccion());
		propiedadDatos.setId_propiedad(prop.getId_propiedad());
		propiedadDatos.setPrecioAlquiler(prop.getPrecioAlquiler());
		propiedadDatos.setTipoPropiedad(prop.getTipoPropiedad());
		propiedadDatos.setInquilinoApellido(inqui.getApellido());
		propiedadDatos.setInquilinoNombre(inqui.getNombre());
		return propiedadDatos;
	}
}