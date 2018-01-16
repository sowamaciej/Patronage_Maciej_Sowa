package com.sowamaciej.BackendApplication;

import com.sowamaciej.BackendApplication.Models.Car;
import com.sowamaciej.BackendApplication.Models.Client;
import com.sowamaciej.BackendApplication.Repository.CarRepository;
import com.sowamaciej.BackendApplication.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class RepositoryInitalizer implements ApplicationRunner {
    private ClientRepository clientRepository;
    private CarRepository carRepository;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    RepositoryInitalizer(ClientRepository clientRepository, CarRepository carRepository) {
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        clientRepository.save(new Client("Jan", "Kowalski", dateFormat.parse("10/01/1990"), "male", "1231231231"));
        carRepository.save(new Car("ZS1231", "HONDA", dateFormat.parse("12/12/2001"), dateFormat.parse("15/12/2011"), 100, 2));


    }
}
