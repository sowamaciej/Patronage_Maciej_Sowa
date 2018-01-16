package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
import com.sowamaciej.BackendApplication.Services.H2CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {


    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> allCars() {
        List<Car> cars = carService.findAllCars();
        return cars;
    }

    @GetMapping("/{carId}")
    public Car findCarById(@PathVariable Long carId) {
        return carService.findById(carId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{carId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@Valid @PathVariable Long carId, @Valid @RequestBody Car car) {
        return carService.update(carId, car);
    }

    @DeleteMapping("/{carId}")
    public Car deleteCar(@PathVariable Long carId) {
        return carService.deleteCar(carId);
    }
}
