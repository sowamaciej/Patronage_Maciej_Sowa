package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Exception.ClientNotFoundException;
import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H2ClientService implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public H2ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Client findById(Long id) {
        if (!repository.exists(id)) {
            throw new ClientNotFoundException();
        }
        return repository.findOne(id);
    }

    @Override
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Long clientId, Client client) {
        if (!repository.exists(clientId)) {
            throw new ClientNotFoundException();
        }
        Client currentClient = findById(clientId);

        if (currentClient != null) {
            currentClient.setName(client.getName());
            currentClient.setLastName(client.getLastName());
            currentClient.setBirthDate(client.getBirthDate());
            currentClient.setSex(client.getSex());
            currentClient.setPesel(client.getPesel());
            return repository.save(currentClient);
        }
        return null;
    }

    @Override
    public Client deleteClient(Long clientId) {
        if (!repository.exists(clientId)) {
            throw new ClientNotFoundException();
        }
        Client removedClient = findById(clientId);
        repository.delete(clientId);
        return removedClient;

    }

}
