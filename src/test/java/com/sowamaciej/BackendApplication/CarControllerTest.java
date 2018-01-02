package com.sowamaciej.BackendApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        car = carController.createCar(new Car(1, "ZS1241", "Ford", "Sedan", "Focus", "18.10.2004", "1HBZI12JK", 1800, "diesel", 2.0, 5));

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
        Car updatedCar = carController.createCar(new Car(1, "ZS1241" + "1", "Ford", "Sedan", "Focus", "18.10.2004", "2CBH12843KL", 1800, "diesel", 2.0, 5));

        mockMvc.perform(put(PATH + "/" + car.getId())
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(updatedCar)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.vehicleBrand", is(updatedCar.getVehicleBrand())))
                .andExpect(jsonPath("$.registrationNumber", is(updatedCar.getRegistrationNumber())));
    }

}
