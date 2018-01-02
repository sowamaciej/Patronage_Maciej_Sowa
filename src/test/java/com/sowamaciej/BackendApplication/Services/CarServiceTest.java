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

    private Car car;

    @MockBean
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        car = new Car(ID, REGISTRATION_NUMBER, BRAND, TYPE, MODEL, PRODUCTION_DATE, VIN, WEIGHT, FUEL_TYPE, CAPACITY, SEATS);

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
        assertEquals(VIN, createdCar.getVinNumber());
    }

    @Test
    public void shouldFindCarById() {
        when(carService.findById(car.getId())).thenReturn(car);
        Car currentCar = carService.findById(car.getId());
        Assert.assertNotNull(currentCar);
    }

    @Test
    public void shouldUpdateCar() {
        Car updateCar = new Car(ID, "PO3553", BRAND, TYPE, MODEL, PRODUCTION_DATE, "AAAA242123", WEIGHT, FUEL_TYPE, CAPACITY, SEATS);
        when(carService.update(car.getId(), updateCar)).thenReturn(updateCar);
        Car currentCar = carService.update(car.getId(), updateCar);
        assertEquals("PO3553", currentCar.getRegistrationNumber());
        assertEquals("AAAA242123", currentCar.getVinNumber());
    }

    @Test
    public void shouldDeleteCarById() {
        when(carService.deleteCar(car.getId())).thenReturn(car);
        Car deletedCar = carService.deleteCar(car.getId());
        assertEquals(REGISTRATION_NUMBER, deletedCar.getRegistrationNumber());
        assertEquals(VIN, deletedCar.getVinNumber());
        assertEquals(BRAND, deletedCar.getVehicleBrand());

    }

}
