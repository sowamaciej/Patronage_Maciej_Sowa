package com.sowamaciej.BackendApplication.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.*;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Pattern(regexp = "^(?!(.).*\1)[A-Z]{2}[0-9]{1,8}$")
    private String registrationNumber;
    @NotNull
    @Pattern(regexp = "HONDA|FIAT|SKODA")
    private String vehicleBrand;
    @NotNull
    private String dateOfFirstRegistration;
    @Min(50)
    @Max(6999)
    @NotNull
    private Integer engineCapacity;
    @NotNull
    private String registrationReleaseDate;

    @Min(1)
    @Max(6)
    private Integer numberOfSeats;

    public Car() {
    }

    public Car( String registrationNumber, String vehicleBrand, String dateOfFirstRegistration, String registrationReleaseDate, Integer engineCapacity, Integer numberOfSeats) {
        this.registrationNumber = registrationNumber;
        this.vehicleBrand = vehicleBrand;
        this.dateOfFirstRegistration = dateOfFirstRegistration;
        this.registrationReleaseDate = registrationReleaseDate;
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

    public Integer getEngineCapacity() {
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

    public void setEngineCapacity(Integer engineCapacity) {
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

