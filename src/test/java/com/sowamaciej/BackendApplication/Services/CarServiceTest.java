package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
import com.sun.org.apache.regexp.internal.RE;
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
public class CarServiceTest {

    private static final Long ID = new Long(1);
    private static final String REGISTRATION_NUMBER = "ZS1241";
    private static final String BRAND = "Ford";
    private static final String PRODUCTION_DATE = "18.10.2004";
    private static final String RELEASE_DATE="19.11.2004";
    private static final Double CAPACITY = 2.0;
    private static final Integer SEATS = 5;

    private Car car;

    @MockBean
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        car = new Car(ID, REGISTRATION_NUMBER, BRAND, PRODUCTION_DATE, RELEASE_DATE,CAPACITY, SEATS);

    }

    @Test
    public void shouldFindAllCars() {

        when(carService.findAllCars()).thenReturn(Collections.emptyList());
        List<Car> cars = carService.findAllCars();
        assertTrue(cars.isEmpty());
    }

    @Test
    public void shouldCreateCar() {
        when(carService.create(car)).thenReturn(car);
        Car createdCar = car;
        assertEquals(REGISTRATION_NUMBER, createdCar.getRegistrationNumber());
    }

    @Test
    public void shouldFindCarById() {
        when(carService.findById(car.getId())).thenReturn(car);
        Car currentCar = carService.findById(car.getId());
        Assert.assertNotNull(currentCar);
    }

    @Test
    public void shouldUpdateCar() {
        Car updateCar = new Car(ID, "PO3553", BRAND, PRODUCTION_DATE,"12/12/2012", CAPACITY, SEATS);
        when(carService.update(car.getId(), updateCar)).thenReturn(updateCar);
        Car currentCar = carService.update(car.getId(), updateCar);
        assertEquals("PO3553", currentCar.getRegistrationNumber());
    }

    @Test
    public void shouldDeleteCarById() {
        when(carService.deleteCar(car.getId())).thenReturn(car);
        Car deletedCar = carService.deleteCar(car.getId());
        assertEquals(REGISTRATION_NUMBER, deletedCar.getRegistrationNumber());
        assertEquals(BRAND, deletedCar.getVehicleBrand());

    }

}
