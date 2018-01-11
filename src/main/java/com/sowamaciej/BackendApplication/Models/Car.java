package com.sowamaciej.BackendApplication.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Car {

    private Long id;
    @NotNull
    private String registrationNumber;
    @NotNull
    private String vehicleBrand;
    @NotNull
    private String dateOfFirstRegistration;
    @NotNull
    private Double engineCapacity;
    @NotNull
    private String registrationReleaseDate;

    private Integer numberOfSeats;

    public Car() {
    }

    public Car(Long id, String registrationNumber, String vehicleBrand, String dateOfFirstRegistration,String registrationReleaseDate, Double engineCapacity, Integer numberOfSeats) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.vehicleBrand = vehicleBrand;
        this.dateOfFirstRegistration = dateOfFirstRegistration;
        this.registrationReleaseDate=registrationReleaseDate;
        this.engineCapacity = engineCapacity;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public String getDateOfFirstRegistration() {
        return dateOfFirstRegistration;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getRegistrationReleaseDate() {
        return registrationReleaseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setDateOfFirstRegistration(String dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
    }

    public void setRegistrationReleaseDate(String registrationReleaseDate) {
        this.registrationReleaseDate = registrationReleaseDate;
    }
}

