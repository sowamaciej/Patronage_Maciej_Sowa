package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Services.ClientService;
import com.sowamaciej.BackendApplication.Services.H2ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;


import java.util.List;

@Api(value = "user", description = "Rest API for operations on clients", tags = "User API for clients")
@RestController
@RequestMapping("/clients")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Server cannot process the request"),
        @ApiResponse(code = 500, message = "Request is ok, unexpected condition was encountered")
})
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Get all clients", response = Client.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client projected"),
            @ApiResponse(code = 404, message = "Clients not found")
    })
    public List<Client> users() {
        List<Client> clients = clientService.findAllClients();
        return clients;
    }

    @ApiOperation(value = "Get client with specified id", response = Client.class)
    @GetMapping(value = "/{clientId}", produces = {"application/json", "application/xml"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client projected"),
            @ApiResponse(code = 404, message = "Client with this id not found")
    })
    public Client findClientById(@PathVariable Long clientId) {
        return clientService.findById(clientId);
    }

    @ApiOperation(value = "Create client and save in data base", response = Client.class)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json", "application/xml"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client created"),

    })
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client modified"),
            @ApiResponse(code = 404, message = "Client with this id not found")
    })
    @ApiOperation(value = "Update client with specified id", response = Client.class)
    @PutMapping(value = "/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json", "application/xml"})
    public Client updateClient(@Valid @PathVariable Long clientId, @Valid @RequestBody Client client) {
        return clientService.update(clientId, client);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client deleted"),
            @ApiResponse(code = 404, message = "Client with this id not found")
    })
    @ApiOperation(value = "Delete client with specified id", response = Client.class)
    @DeleteMapping(value = "/{clientId}", produces = {"application/json", "application/xml"})
    public Client deleteClient(@PathVariable Long clientId) {
        return clientService.deleteClient(clientId);
    }


}
