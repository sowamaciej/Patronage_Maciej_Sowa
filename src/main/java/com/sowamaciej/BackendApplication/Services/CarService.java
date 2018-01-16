package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;

import java.util.List;

public interface CarService {

    List<Car> findAllCars();

    Car findById(Long id);

    Car create(Car car);

    Car update(Long carId, Car car);

    Car deleteCar(Long carId);

}
