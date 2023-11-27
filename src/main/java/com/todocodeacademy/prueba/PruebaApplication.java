package com.todocodeacademy.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
 * El paquete del controlador es escaneado por Spring: Asegúrate de que el paquete que contiene tu controlador (ApplicacionController) esté dentro del escaneo de componentes de Spring. 
 * Si la clase está en un paquete diferente, puedes agregar la anotación @ComponentScan en tu clase principal (PruebaApplication) para especificar el paquete base.
 * @ComponentScan es esencial en algunas configuraciones de Spring para asegurarse de que los componentes, como controladores, sean detectados por el escaneo automático de Spring.
 */
@ComponentScan(basePackages = "com.todocodeacademy")
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
