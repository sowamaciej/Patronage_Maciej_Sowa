package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Services.ClientService;
import com.sun.javafx.image.impl.BaseIntToByteConverter;
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

    private static final long ID=1;
    private static final String NAME="name";
    private static final String LAST_NAME="lastname";
    private static final String BIRTH_DATE = "12/12/1944";
    private static final String SEX="male";
    private static final String PESEL="44121245115";

    private Client client;

    @MockBean
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        client = new Client(ID, NAME, LAST_NAME, BIRTH_DATE, SEX, PESEL);

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
        assertEquals(NAME, createdClient.getName());
        assertEquals(LAST_NAME, createdClient.getLastName());
    }

    @Test
    public void shouldFindClientById() {
        when(clientService.findById(client.getId())).thenReturn(client);
        Client currentClient = clientService.findById(client.getId());
        Assert.assertNotNull(currentClient);
    }

    @Test
    public void shouldUpdateClient() {
        Client updateClient = new Client(ID, NAME+"ABC", LAST_NAME+"ABC", BIRTH_DATE, SEX, "123");
        when(clientService.update(client.getId(), updateClient)).thenReturn(updateClient);
        Client currentClient = clientService.update(client.getId(), updateClient);
        assertEquals(NAME+"ABC", currentClient.getName());
        assertEquals(LAST_NAME+"ABC", currentClient.getLastName());
        assertEquals("123",currentClient.getPesel());
    }

    @Test
    public void shouldDeleteClientById() {
        when(clientService.deleteClient(client.getId())).thenReturn(client);
        Client deletedClient = clientService.deleteClient(client.getId());
        assertEquals(NAME, deletedClient.getName());
        assertEquals(SEX, deletedClient.getSex());

    }

}
