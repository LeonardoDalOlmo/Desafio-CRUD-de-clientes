package com.aula.projeto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aula.projeto.entities.Client;
import com.aula.projeto.repository.ClientRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ClientRepository repository;

    @Override
    public void run(String... args) {
        repository.saveAll(List.of(
            new Client(null, "Ana Oliveira", "12345678901", 4500.0, LocalDate.of(1990, 5, 20), 1),
            new Client(null, "Carlos Silva", "23456789012", 7200.0, LocalDate.of(1985, 8, 10), 2),
            new Client(null, "Beatriz Costa", "34567890123", 3300.0, LocalDate.of(1992, 12, 5), 0)
            // +7 clientes com dados reais
        ));
    }
}
