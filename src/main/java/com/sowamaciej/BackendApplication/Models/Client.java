package com.sowamaciej.BackendApplication.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@ApiModel(value="Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "The database generated client ID", position = 1)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Name of the client", example = "Maciej", position = 2)
    private String name;

    @NotNull
    @ApiModelProperty(value = "Surname of the client", example = "Sowa", position = 3)
    private String lastName;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @ApiModelProperty(value = "Date of birth: dd/mm/yyyy", example = "12/12/1993", position = 4)
    private Date birthDate;

    @NotNull
    @ApiModelProperty(value = "Client gender", example = "male", position = 5)
    private String sex;

    @NotNull
    @ApiModelProperty(value = "Personal identity number", example = "12345678890")
    private String pesel;

    public Client() {
    }

    public Client(String name, String lastName, Date birthDate, String sex, String pesel) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.pesel = pesel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public String getSex() {
        return sex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
