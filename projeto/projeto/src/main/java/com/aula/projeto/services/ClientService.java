package com.aula.projeto.services;



import com.aula.projeto.repository.ClientRepository;
import com.aula.projeto.services.Exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aula.projeto.dto.ClientDTO;
import com.aula.projeto.entities.Client;

public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Page<ClientDTO> findAllPaged(Pageable pageable){
        return repository.findAll(pageable).map(ClientDTO::new);
    }

    public ClientDTO findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClientDTO(client);
    }   

    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
    
    public ClientDTO update (Long id, ClientDTO dto){
        try{
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    public void delet (Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        repository.deleteById(id);
    }



    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
