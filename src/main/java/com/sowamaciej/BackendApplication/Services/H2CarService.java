package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H2CarService implements CarService {

    private final CarRepository repository;

    @Autowired
    public H2CarService(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> findAllCars() {
        return repository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Car create(Car car) {
        return repository.save(car);
    }

    @Override
    public Car update(Long carId, Car car) {
        Car currentCar = findById(carId);

        if (currentCar != null) {
            currentCar.setRegistrationNumber(car.getRegistrationNumber());
            currentCar.setVehicleBrand(car.getVehicleBrand());
            currentCar.setEngineCapacity(car.getEngineCapacity());
            currentCar.setNumberOfSeats(car.getNumberOfSeats());
            currentCar.setDateOfFirstRegistration(car.getDateOfFirstRegistration());
            currentCar.setRegistrationReleaseDate(car.getRegistrationReleaseDate());
            return repository.save(currentCar);
        }
        return null;
    }

    @Override
    public Car deleteCar(Long carId) {
        Car removedCar = findById(carId);
        repository.delete(carId);
        return removedCar;
    }

}
