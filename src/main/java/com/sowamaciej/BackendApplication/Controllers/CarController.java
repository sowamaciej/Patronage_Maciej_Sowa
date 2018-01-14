package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Car;
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
    @Autowired
    private H2CarService h2CarService;

    @GetMapping
    public List<Car> allCars() {
        List<Car> cars = h2CarService.findAllCars();
        return cars;
    }
    @GetMapping("/{carId}")
    public Car findCarById(@PathVariable Long carId) {
        return h2CarService.findById(carId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@Valid @RequestBody Car car) {
        return h2CarService.create(car);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{carId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@Valid @PathVariable Long carId,@Valid @RequestBody Car car) {
        return h2CarService.update(carId, car);
    }

    @DeleteMapping("/{carId}")
    public Car deleteCar(@PathVariable Long carId) {
        return h2CarService.deleteCar(carId);
    }
}
