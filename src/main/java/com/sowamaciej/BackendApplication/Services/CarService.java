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

    public Car findById(long id) {
        for (Car car : cars) {
            if (car.getId() == id) return car;
        }
        return null;
    }

    public Car create(Car car) {
        car.setId(counter.incrementAndGet());
        cars.add(car);
        return car;
    }

    public Car update(long carId, Car car) {
        Car currentCar = findById(carId);

        if (currentCar != null) {
            currentCar.setRegistrationNumber(car.getRegistrationNumber());
            currentCar.setVehicleBrand(car.getVehicleBrand());
            currentCar.setVehicleModel(car.getVehicleModel());
            currentCar.setVehicleType(car.getVehicleType());
            currentCar.setVinNumber(car.getVinNumber());
            currentCar.setWeight(car.getWeight());
            currentCar.setFuelType(car.getFuelType());
            currentCar.setEngineCapacity(car.getEngineCapacity());
            currentCar.setNumberOfSeats(car.getNumberOfSeats());
            return currentCar;
        }
        return null;
    }

    public Car deleteCar(long carId) {
        Car removedCar = findById(carId);
        for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext(); ) {
            Car car = iterator.next();
            if (car.getId() == carId)
                iterator.remove();
        }
        return removedCar;
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(counter.incrementAndGet(), "ZS12411", "Opel", "Hatchback", "Astra", "12/30/1980", "1234551", 1650, "benzyna", 2.4, 5));
        return cars;
    }

}
