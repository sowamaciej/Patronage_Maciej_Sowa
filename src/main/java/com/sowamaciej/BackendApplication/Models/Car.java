package com.sowamaciej.BackendApplication.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sowamaciej.BackendApplication.Validators.DateInRange;
import com.sowamaciej.BackendApplication.Validators.ReleaseDateInRange;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.*;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@ApiModel(value = "Car")
@ReleaseDateInRange
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "The database generated car ID", position = 1)
    @JsonProperty
    private Long id;

    @NotNull
    @Pattern(regexp = "^(?!(.).*\1)[A-Z]{2}[0-9]{1,8}$")
    @ApiModelProperty(value = "Car registration number ", position = 2, example = "ZS1234")
    private String registrationNumber;

    @NotNull
    @Pattern(regexp = "HONDA|FIAT|SKODA")
    @ApiModelProperty(value = "Car brand", position = 3, example = "HONDA")
    private String vehicleBrand;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateInRange
    @ApiModelProperty(value = "Date of first registration: dd/mm/yyyy", example = "12/12/1990", position = 4)
    private Date dateOfFirstRegistration;

    @Min(50)
    @Max(6999)
    @NotNull
    @ApiModelProperty(value = "Engine capacity", position = 5, example = "100")
    private Integer engineCapacity;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @ApiModelProperty(value = "Registration release date: dd/mm/yyyy", example = "12/12/2017", position = 6)
    private Date registrationReleaseDate;

    @Min(1)
    @Max(6)
    @ApiModelProperty(value = "Numbers of seat", position = 7, example = "4")
    private Integer numberOfSeats;

    public Car() {
    }

    public Car(String registrationNumber, String vehicleBrand, Date dateOfFirstRegistration, Date registrationReleaseDate, Integer engineCapacity, Integer numberOfSeats) {
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

    public Date getDateOfFirstRegistration() {
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

    public Date getRegistrationReleaseDate() {
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

    public void setDateOfFirstRegistration(Date dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
    }

    public void setRegistrationReleaseDate(Date registrationReleaseDate) {
        this.registrationReleaseDate = registrationReleaseDate;
    }
}

