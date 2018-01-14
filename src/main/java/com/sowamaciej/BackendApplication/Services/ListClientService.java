package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import java.util.List;
import java.util.Iterator;

@Service
public class ListClientService implements ClientService {

    private static final AtomicLong counter = new AtomicLong();
    private static List<Client> clients;

    public ListClientService(){
        clients=new ArrayList<>();
    }
    @Override
    public List<Client> findAllClients() {
        return clients;
    }

    @Override
    public Client findById(Long id) {
        for (Client client : clients) {
            if (client.getId() == id) return client;
        }
        return null;
    }

    @Override
    public Client create(Client client) {
        client.setId(counter.incrementAndGet());
        clients.add(client);
        return client;
    }

    @Override
    public Client update(Long clientId, Client client) {
        Client currentClient = findById(clientId);

        if (currentClient != null) {
            currentClient.setName(client.getName());
            currentClient.setLastName(client.getLastName());
            currentClient.setBirthDate(client.getBirthDate());
            currentClient.setSex(client.getSex());
            currentClient.setPesel(client.getPesel());
            return currentClient;
        }
        return null;
    }

    @Override
    public Client deleteClient(Long clientId) {
        Client removedClient = findById(clientId);
        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext(); ) {
            Client client = iterator.next();
            if (client.getId() == clientId)
                iterator.remove();
        }
        return removedClient;
    }


}