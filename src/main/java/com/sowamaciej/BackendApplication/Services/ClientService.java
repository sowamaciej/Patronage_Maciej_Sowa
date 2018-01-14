package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();

    Client findById(Long id);

    Client create(Client client);

    Client update(Long clientId, Client client);

    Client deleteClient(Long clientId);
}
