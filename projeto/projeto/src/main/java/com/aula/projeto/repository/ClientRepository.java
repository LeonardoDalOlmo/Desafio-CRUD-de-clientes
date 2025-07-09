package com.aula.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.projeto.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
