package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
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

    private Car car;

    @MockBean
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        car = new Car(1, "ZS1241", "Ford", "Sedan", "Focus", "18.10.2004", "2CBH12843KL", 1800, "diesel", 2.0, 5);

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
        assertEquals("ZS1241", createdCar.getRegistrationNumber());
        assertEquals("2CBH12843KL", createdCar.getVinNumber());
    }

    @Test
    public void shouldFindCarById() {
        when(carService.findById(car.getId())).thenReturn(car);
        Car currentCar = carService.findById(car.getId());
        Assert.assertNotNull(currentCar);
    }

    @Test
    public void shouldUpdateCar() {
        Car updateCar = new Car(1, "PO3553", "Ford", "Sedan", "Focus", "18.10.2004", "AAAA242123", 1800, "diesel", 2.0, 5);
        when(carService.update(car.getId(), updateCar)).thenReturn(updateCar);
        Car currentCar = carService.update(car.getId(), updateCar);
        assertEquals("PO3553", currentCar.getRegistrationNumber());
        assertEquals("AAAA242123", currentCar.getVinNumber());
    }

    @Test
    public void shouldDeleteCarById() {
        when(carService.deleteCar(car.getId())).thenReturn(car);
        Car deletedCar = carService.deleteCar(car.getId());
        assertEquals("ZS1241", deletedCar.getRegistrationNumber());
        assertEquals("2CBH12843KL", deletedCar.getVinNumber());
        assertEquals("Ford", deletedCar.getVehicleBrand());

    }

}
