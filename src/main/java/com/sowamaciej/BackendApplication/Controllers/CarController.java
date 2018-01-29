package com.sowamaciej.BackendApplication.Controllers;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Services.CarService;
import com.sowamaciej.BackendApplication.Services.H2CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import javax.validation.Valid;

@Api(value = "user", description = "Rest API for operations on cars", tags = "User API for cars")
@RestController
@RequestMapping("/cars")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Server cannot process the request"),
        @ApiResponse(code = 500, message = "Request is ok, unexpected condition was encountered")
})
public class CarController {


    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ApiOperation(value = "Get all cars")
    @GetMapping(produces = {"application/json", "application/xml"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cars projected"),
            @ApiResponse(code = 404, message = "Cars not found")
    })
    public List<Car> allCars() {
        List<Car> cars = carService.findAllCars();
        return cars;
    }

    @ApiOperation(value = "Get car with specified id")
    @GetMapping(value = "/{carId}", produces = {"application/json", "application/xml"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Car projected"),
            @ApiResponse(code = 404, message = "Car with this id not found")
    })
    public Car findCarById(@PathVariable Long carId) {
        return carService.findById(carId);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Car created"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create car and insert into database")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json", "application/xml"})
    public Car createCar(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Car modified"),
            @ApiResponse(code = 404, message = "Car with this id not found")
    })
    @ApiOperation(value = "Update car with specified id")
    @RequestMapping(method = RequestMethod.PUT, value = "/{carId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json", "application/xml"})

    public Car updateCar(@Valid @PathVariable Long carId, @Valid @RequestBody Car car) {
        return carService.update(carId, car);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Car deleted"),
            @ApiResponse(code = 404, message = "Car with this id not found")
    })
    @ApiOperation(value = "Delete car with specified id")
    @DeleteMapping(value = "/{carId}", produces = {"application/json", "application/xml"})
    public Car deleteCar(@PathVariable Long carId) {
        return carService.deleteCar(carId);
    }
}
