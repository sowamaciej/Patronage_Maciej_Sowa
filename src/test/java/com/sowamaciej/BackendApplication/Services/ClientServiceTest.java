package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Services.ClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ClientServiceTest {

    private Client client;

    @MockBean
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        client = new Client(1, "name", "lastName", "12/12/1944", "male", "44121245115");

    }

    @Test
    public void shouldFindAllClients() {

        when(clientService.findAllClients()).thenReturn(Collections.emptyList());
        List<Client> clients = clientService.findAllClients();
        assertTrue(clients.isEmpty());
    }

    @Test
    public void shouldCreateClient() {
        when(clientService.create(client)).thenReturn(client);
        Client createdClient = client;
        assertEquals("name", createdClient.getName());
        assertEquals("lastName", createdClient.getLastName());
    }

    @Test
    public void shouldFindClientById() {
        when(clientService.findById(client.getId())).thenReturn(client);
        Client currentClient = clientService.findById(client.getId());
        Assert.assertNotNull(currentClient);
    }

    @Test
    public void shouldUpdateClient() {
        Client updateClient = new Client(1, "name" + "N", "lastName" + "B", "12/12/1244", "male", "123");
        when(clientService.update(client.getId(), updateClient)).thenReturn(updateClient);
        Client currentClient = clientService.update(client.getId(), updateClient);
        assertEquals("name" + "N", currentClient.getName());
        assertEquals("lastName" + "B", currentClient.getLastName());
        assertEquals("123",currentClient.getPesel());
    }

    @Test
    public void shouldDeleteClientById() {
        when(clientService.deleteClient(client.getId())).thenReturn(client);
        Client deletedClient = clientService.deleteClient(client.getId());
        assertEquals("name", deletedClient.getName());
        assertEquals("male", deletedClient.getSex());

    }

}
