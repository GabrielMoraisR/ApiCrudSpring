package com.example.crud.controllers;

import com.example.crud.domain.client.Client;
import com.example.crud.domain.client.ClientsRepository;
import com.example.crud.domain.client.RequestClients;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientsRepository repository;

    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity registerClient(@RequestBody RequestClients data){
        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid RequestClients data) {
        Optional<Client> optionalClient = repository.findById(data.id());

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            client.setName(data.name());
            client.setEmail(data.email());
            client.setCpf(data.cpf());

            repository.save(client);
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
