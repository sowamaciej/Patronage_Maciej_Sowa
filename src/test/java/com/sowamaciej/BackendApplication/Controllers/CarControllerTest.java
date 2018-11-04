package com.sowamaciej.BackendApplication.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
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
public class CarControllerTest {

    private static final Long ID = 1L;
    private static final String REGISTRATION_NUMBER = "AA11212";
    private static final String BRAND = "HONDA";
    private static final String PRODUCTION_DATE = "18/10/2004";
    private static final String RELEASE_DATE = "19/11/2004";
    private static final Integer CAPACITY = 67;
    private static final Integer SEATS = 5;
    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");


    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private final static String PATH = "/cars";

    private Car car;
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CarService carService;

    @Before
    public void setUP() {
        MockitoAnnotations.initMocks(this);
        try {
            car = new Car(REGISTRATION_NUMBER, BRAND, dateParser.parse(PRODUCTION_DATE), dateParser.parse(RELEASE_DATE), CAPACITY, SEATS);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        final CarController carController = new CarController(carService);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void shouldGetAllCars() throws Exception {
        List<Car> cars = carService.findAllCars();
        mockMvc.perform(get(PATH))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindCarById() throws Exception {
        carService.create(car);
        Car created = carService.findById(ID);
        mockMvc.perform(get(PATH + "/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(created.getId().intValue())));

    }

    @Test
    public void createCar() throws Exception {
        carService.create(car);
        mockMvc.perform(post(PATH)
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void deleteCar() throws Exception {
        carService.create(car);
        mockMvc.perform(delete(PATH + "/" + car.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(car.getId().intValue())));
    }

    @Test
    public void updateCar() throws Exception {
        Car updatedCar;
        try {
            updatedCar = new Car("PO3553", BRAND, dateParser.parse(PRODUCTION_DATE), dateParser.parse(RELEASE_DATE), CAPACITY, SEATS);

        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        Car created = carService.create(car);
        Car updated = carService.update(created.getId(), updatedCar);
        mockMvc.perform(put(PATH + "/" + car.getId())
                .contentType(contentType)
                .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.vehicleBrand", is(updated.getVehicleBrand())))
                .andExpect(jsonPath("$.registrationNumber", is(updated.getRegistrationNumber())));
    }

}
