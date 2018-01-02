package com.sowamaciej.BackendApplication.Controllers;

import static org.hamcrest.Matchers.*;

import com.sowamaciej.BackendApplication.Controllers.ClientController;
import com.sowamaciej.BackendApplication.Models.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

    private static final long ID = 1;
    private static final String NAME = "name";
    private static final String LAST_NAME = "lastname";
    private static final String BIRTH_DATE = "12/12/1944";
    private static final String SEX = "male";
    private static final String PESEL = "44121245115";

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private final static String PATH = "/clients";

    private Client client;
    private MockMvc mockMvc;

    @Autowired
    private ClientController clientController;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUP() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
        client = clientController.createClient(new Client(ID, NAME, LAST_NAME, BIRTH_DATE, SEX, PESEL));

    }

    @Test
    public void shouldFindAllClients() throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(clientController.users().size())));
    }

    @Test
    public void shouldFindClientById() throws Exception {
        mockMvc.perform(get(PATH + "/" + client.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(client.getId().intValue())));

    }

    @Test
    public void shouldCreateClient() throws Exception {
        mockMvc.perform(post(PATH)
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void shouldDeleteClient() throws Exception {
        mockMvc.perform(delete(PATH + "/" + client.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(client.getId().intValue())));


    }

    @Test
    public void shouldUpdateClient() throws Exception {
        Client updatedClient = clientController.createClient(new Client(ID, NAME+"ABC", LAST_NAME+"ABC", BIRTH_DATE, SEX, "123"));

        mockMvc.perform(put(PATH + "/" + client.getId())
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(updatedClient)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name", is(updatedClient.getName())))
                .andExpect(jsonPath("$.lastName", is(updatedClient.getLastName())))
                .andExpect(jsonPath("$.pesel", is(updatedClient.getPesel())));
    }

}
