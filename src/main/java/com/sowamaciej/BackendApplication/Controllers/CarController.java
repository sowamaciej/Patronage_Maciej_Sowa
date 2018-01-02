package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
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
    CarService carService;

    @GetMapping
    public List<Car> allCars() {
        List<Car> cars = carService.findAllCars();
        return cars;
    }

    @GetMapping("/{carId}")
    public Car findCarById(@PathVariable long carId) {
        return carService.findById(carId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping(value = "/{carId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car updateClient(@Valid @PathVariable long carId, @RequestBody Car car) {
        return carService.update(carId, car);
    }

    @DeleteMapping("/{carId}")
    public Car deleteCar(@PathVariable long carId) {
        return carService.deleteCar(carId);
    }
}
