package com.sowamaciej.BackendApplication;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Car {

    private long id;
    @NotNull
    private String registrationNumber;
    @NotNull
    private String vehicleBrand;
    private String vehicleType;
    @NotNull
    private String vehicleModel;
    private String dateOfProduction;
    @NotNull
    private String vinNumber;
    private double weight;
    @NotNull
    private String fuelType;
    private double engineCapacity;
    private int numberOfSeats;

    public Car() {
    }

    public Car(long id, String registrationNumber, String vehicleBrand, String vehicleType, String vehicleModel, String dateOfProduction, String vinNumber, double weight, String fuelType, double engineCapacity, int numberOfSeats) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.dateOfProduction = dateOfProduction;
        this.vinNumber = vinNumber;
        this.weight = weight;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public double getWeight() {
        return weight;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

}

