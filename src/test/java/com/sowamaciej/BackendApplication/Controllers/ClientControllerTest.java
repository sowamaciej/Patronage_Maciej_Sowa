package com.sowamaciej.BackendApplication.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Services.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

    private static final long ID = 1L;
    private static final String NAME = "name";
    private static final String LAST_NAME = "lastname";
    private static final String BIRTH_DATE = "12/12/1944";
    private static final String SEX = "male";
    private static final String PESEL = "44121245115";
    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");


    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private final static String PATH = "/clients";

    private Client client;
    private MockMvc mockMvc;

    @Autowired
    private ClientService clientService;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUP() {
        MockitoAnnotations.initMocks(this);
        try {
            client = new Client(NAME, LAST_NAME, dateParser.parse(BIRTH_DATE), SEX, PESEL);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        final ClientController clientController = new ClientController(clientService);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void shouldFindAllClients() throws Exception {
        List<Client> clients = clientService.findAllClients();
        mockMvc.perform(get(PATH))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindClientById() throws Exception {
        clientService.create(client);
        Client created = clientService.findById(ID);
        mockMvc.perform(get(PATH + "/" + created.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateClient() throws Exception {
        Client createClient;
        try {
            createClient = new Client(NAME, LAST_NAME, dateParser.parse(BIRTH_DATE), SEX, PESEL);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        createClient = clientService.create(createClient);
        mockMvc.perform(post(PATH)
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(createClient)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void shouldDeleteClient() throws Exception {
        clientService.create(client);
        mockMvc.perform(delete(PATH + "/" + client.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(client.getId().intValue())));


    }

    @Test
    public void shouldUpdateClient() throws Exception {
        Client updatedClient;
        try {
            updatedClient = new Client(NAME + "ABC", LAST_NAME + "ABC", dateParser.parse(BIRTH_DATE), SEX, "123");
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        Client created = clientService.create(client);
        Client updated = clientService.update(client.getId(), updatedClient);
        mockMvc.perform(put(PATH + "/" + created.getId())
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name", is(updated.getName())))
                .andExpect(jsonPath("$.lastName", is(updated.getLastName())))
                .andExpect(jsonPath("$.pesel", is(updated.getPesel())));
    }

}
