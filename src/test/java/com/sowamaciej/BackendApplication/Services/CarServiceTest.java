package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CarServiceTest {

    private static final Long ID = new Long(1);
    private static final String REGISTRATION_NUMBER = "ZS1241";
    private static final String BRAND = "Ford";
    private static final String PRODUCTION_DATE = "11/10/2004";
    private static final String RELEASE_DATE = "19/11/2004";
    private static final Integer CAPACITY = 60;
    private static final Integer SEATS = 5;
    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");

    private Car car;

    @Mock
    private CarRepository carRepository;
    @Mock
    private H2CarService carService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        carService = new H2CarService(carRepository);
        try {
            car = new Car(REGISTRATION_NUMBER, BRAND, dateParser.parse(PRODUCTION_DATE), dateParser.parse(RELEASE_DATE), CAPACITY, SEATS);

        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        carRepository.save(car);

    }

    @Test
    public void shouldFindAllCars() {
        carService.findAllCars();
        verify(carRepository).findAll();

    }

    @Test
    public void shouldCreateCar() {
        when(carRepository.save(car)).thenReturn(car);
        Car repoCar = carService.create(car);
        assertEquals(REGISTRATION_NUMBER, repoCar.getRegistrationNumber());

    }

    @Test
    public void shouldFindCarById() {
        when(carRepository.exists(anyLong())).thenReturn(true);
        carService.findById(anyLong());

    }

    @Test
    public void shouldUpdateCar() {
        when(carRepository.exists(ID)).thenReturn(true);
        when(carRepository.save(any(Car.class))).thenReturn(car);
        Car repoCar = carService.update(ID, car);
    }

    @Test
    public void shouldDeleteCarById() {
        when(carRepository.exists(ID)).thenReturn(true);
        carService.deleteCar(ID);
    }

}
