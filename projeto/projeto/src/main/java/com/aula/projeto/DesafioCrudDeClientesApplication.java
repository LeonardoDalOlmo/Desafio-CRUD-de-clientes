package com.aula.projeto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioCrudDeClientesApplication {

	public static void main(String[] args) {
		System.setProperty("spring.h2.console.enabled", "true");
		SpringApplication.run(DesafioCrudDeClientesApplication.class, args);
	}

}
