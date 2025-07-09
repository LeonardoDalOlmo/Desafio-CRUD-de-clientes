package com.aula.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aula.projeto.dto.ClientDTO;
import com.aula.projeto.services.ClientService;

import jakarta.validation.Valid;

public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return service.findAllPaged(pageable);
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO insert(@Valid @RequestBody ClientDTO dto){
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delet(id);
    }
}
