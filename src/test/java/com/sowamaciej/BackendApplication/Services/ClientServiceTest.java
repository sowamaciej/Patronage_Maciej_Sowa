package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Repository.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ClientServiceTest {

    private static final long ID = 1;
    private static final String NAME = "name";
    private static final String LAST_NAME = "lastname";
    private static final String BIRTH_DATE = "12/12/1944";
    private static final String SEX = "male";
    private static final String PESEL = "44121245115";
    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");

    private Client client;

    @Mock
    private ClientRepository clientRepository;

    private H2ClientService clientService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        try {
            client = new Client(NAME, LAST_NAME, dateParser.parse(BIRTH_DATE), SEX, PESEL);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);

        }
        clientService = new H2ClientService(clientRepository);
    }

    @Test
    public void shouldFindAllClients() {
        clientService.findAllClients();
        verify(clientRepository).findAll();
    }

    @Test
    public void shouldCreateClient() {
        when(clientService.create(client)).thenReturn(client);
        Client createdClient = clientService.create(client);
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
        Client updateClient;
        try {
            updateClient = new Client(NAME + "ABC", LAST_NAME + "ABC", dateParser.parse(BIRTH_DATE), SEX, "123");
        } catch (ParseException ex) {
            throw new RuntimeException(ex);

        }
        when(clientRepository.exists(ID)).thenReturn(true);
        clientService.update(ID, updateClient);
        clientRepository.save(updateClient);
        verify(clientRepository).save(any(Client.class));
    }

    @Test
    public void shouldDeleteClientById() {
        when(clientRepository.exists(anyLong())).thenReturn(true);
        clientService.deleteClient(anyLong());
        verify(clientRepository).delete(anyLong());


    }

}
