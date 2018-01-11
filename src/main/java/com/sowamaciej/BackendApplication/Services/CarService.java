package com.sowamaciej.BackendApplication.Services;

import com.sowamaciej.BackendApplication.Models.Car;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class CarService {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Car> cars;

    static {
        cars = initCars();
    }

    public List<Car> findAllCars() {
        return cars;
    }

    public Car findById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) return car;
        }
        return null;
    }

    public Car create(Car car) {
        car.setId(counter.incrementAndGet());
        cars.add(car);
        return car;
    }

    public Car update(Long carId, Car car) {
        Car currentCar = findById(carId);

        if (currentCar != null) {
            currentCar.setRegistrationNumber(car.getRegistrationNumber());
            currentCar.setVehicleBrand(car.getVehicleBrand());
            currentCar.setEngineCapacity(car.getEngineCapacity());
            currentCar.setNumberOfSeats(car.getNumberOfSeats());
            currentCar.setDateOfFirstRegistration(car.getDateOfFirstRegistration());
            currentCar.setRegistrationReleaseDate(car.getRegistrationReleaseDate());
            return currentCar;
        }
        return null;
    }

    public Car deleteCar(Long carId) {
        Car removedCar = findById(carId);
        for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext(); ) {
            Car car = iterator.next();
            if (car.getId().equals(carId))
                iterator.remove();
        }
        return removedCar;
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(counter.incrementAndGet(), "ZS12411", "Opel", "12/30/1980","16/30/1981",2.1,5));
        return cars;
    }

}
