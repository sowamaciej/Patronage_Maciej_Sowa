package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.Iterator;

@Service
public class ListCarService implements CarService {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Car> cars;

    @Override
    public List<Car> findAllCars() {
        return cars;
    }

    @Override
    public Car findById(Long id) {
        for (Car car : cars) {
            if (car.getId() == id) return car;
        }
        return null;
    }

    @Override
    public Car create(Car car) {
        car.setId(counter.incrementAndGet());
        cars.add(car);
        return car;
    }

    @Override
    public Car update(Long carId, Car car) {
        Car currentCar = findById(carId);

        if (currentCar != null) {
            currentCar.setRegistrationNumber(car.getRegistrationNumber());
            currentCar.setVehicleBrand(car.getVehicleBrand());
            currentCar.setEngineCapacity(car.getEngineCapacity());
            currentCar.setNumberOfSeats(car.getNumberOfSeats());
            return currentCar;
        }
        return null;
    }

    @Override
    public Car deleteCar(Long carId) {
        Car removedCar = findById(carId);
        for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext(); ) {
            Car car = iterator.next();
            if (car.getId() == carId)
                iterator.remove();
        }
        return removedCar;
    }

}