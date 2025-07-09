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
            new Client(null, "Beatriz Costa", "34567890123", 3300.0, LocalDate.of(1992, 12, 5), 0),
            new Client(null, "Daniel Souza", "45678901234", 5800.0, LocalDate.of(1988, 3, 15), 3),
            new Client(null, "Fernanda Lima", "56789012345", 9100.0, LocalDate.of(1975, 7, 25), 2),
            new Client(null, "Gustavo Almeida", "67890123456", 2900.0, LocalDate.of(1999, 11, 9), 0),
            new Client(null, "Helena Duarte", "78901234567", 6300.0, LocalDate.of(1982, 1, 30), 1),
            new Client(null, "Igor Martins", "89012345678", 4700.0, LocalDate.of(1995, 6, 18), 2),
            new Client(null, "Juliana Ribeiro", "90123456789", 8100.0, LocalDate.of(1991, 9, 2), 0),
            new Client(null, "Lucas Fernandes", "01234567890", 5500.0, LocalDate.of(1987, 4, 12), 3)
        ));
    }
}
