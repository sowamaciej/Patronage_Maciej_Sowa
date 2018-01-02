package com.sowamaciej.BackendApplication.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sowamaciej.BackendApplication.Controllers.CarController;
import com.sowamaciej.BackendApplication.Models.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarControllerTest {

    private static final long ID = 1;
    private static final String REGISTRATION_NUMBER = "ZS1241";
    private static final String BRAND = "Ford";
    private static final String TYPE = "Sedan";
    private static final String MODEL = "Focus";
    private static final String PRODUCTION_DATE = "18.10.2004";
    private static final String VIN = "2CBH12843KL";
    private static final double WEIGHT = 1800;
    private static final String FUEL_TYPE = "diesel";
    private static final double CAPACITY = 2.0;
    private static final int SEATS = 5;

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private final static String PATH = "/cars";

    private Car car;

    private MockMvc mockMvc;

    @Autowired
    private CarController carController;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUP() {
        car = carController.createCar(new Car(ID, REGISTRATION_NUMBER, BRAND, TYPE, MODEL, PRODUCTION_DATE, VIN, WEIGHT, FUEL_TYPE, CAPACITY, SEATS));

        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get(PATH))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(carController.allCars().size())));
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get(PATH + "/" + car.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(car.getId().intValue())));

    }

    @Test
    public void createCar() throws Exception {
        mockMvc.perform(post(PATH)
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void deleteCar() throws Exception {
        mockMvc.perform(delete(PATH + "/" + car.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(car.getId().intValue())));


    }

    @Test
    public void updateCar() throws Exception {
        Car updatedCar = carController.createCar(new Car(ID, "PO3553", BRAND, TYPE, MODEL, PRODUCTION_DATE, "AAAA242123", WEIGHT, FUEL_TYPE, CAPACITY, SEATS));

        mockMvc.perform(put(PATH + "/" + car.getId())
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(updatedCar)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.vehicleBrand", is(updatedCar.getVehicleBrand())))
                .andExpect(jsonPath("$.registrationNumber", is(updatedCar.getRegistrationNumber())));
    }

}
