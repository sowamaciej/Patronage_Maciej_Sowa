package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> users() {
        List<Client> clients = clientService.findAllClients();
        return clients;
    }

    @GetMapping("/{clientId}")
    public Client findClientById(@PathVariable long clientId) {
        return clientService.findById(clientId);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping(value = "/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@Valid @PathVariable long clientId, @RequestBody Client client) {
        return clientService.update(clientId, client);
    }

    @DeleteMapping("/{clientId}")
    public Client deleteClient(@PathVariable long clientId) {
        return clientService.deleteClient(clientId);
    }


}
