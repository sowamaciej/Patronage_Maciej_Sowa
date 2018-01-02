package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class ClientService {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Client> clients;

    static {
        clients = initClients();
    }

    public List<Client> findAllClients() {
        return clients;
    }

    public Client findById(long id) {
        for (Client client : clients) {
            if (client.getId() == id) return client;
        }
        return null;
    }

    public Client create(Client client) {
        client.setId(counter.incrementAndGet());
        clients.add(client);
        return client;
    }

    public Client update(long clientId, Client client) {
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

    public Client deleteClient(long clientId) {
        Client removedClient = findById(clientId);
        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext(); ) {
            Client client = iterator.next();
            if (client.getId() == clientId)
                iterator.remove();
        }
        return removedClient;
    }

    private static List<Client> initClients() {
        List<Client> clients = new ArrayList<Client>();
        clients.add(new Client(counter.incrementAndGet(), "Adam", "Kowalski", "12/10/1986", "male", "86121058018"));
        clients.add(new Client(counter.incrementAndGet(), "Janusz", "Nowak", "01/10/1983", "male", "83011026517"));
        clients.add(new Client(counter.incrementAndGet(), "Jan", "Baryla", "12/12/2000", "male", "00321275116"));

        return clients;
    }

}
