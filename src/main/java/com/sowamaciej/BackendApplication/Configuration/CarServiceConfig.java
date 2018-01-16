package com.sowamaciej.BackendApplication.Configuration;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Repository.CarRepository;
import com.sowamaciej.BackendApplication.Services.CarService;
import com.sowamaciej.BackendApplication.Services.H2CarService;
import com.sowamaciej.BackendApplication.Services.ListCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarServiceConfig {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceConfig(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "TRUE")
    public CarService h2CarService() {
        return new H2CarService(carRepository);
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "FALSE", matchIfMissing = true)
    public CarService listCarService() {
        return new ListCarService();
    }
}
