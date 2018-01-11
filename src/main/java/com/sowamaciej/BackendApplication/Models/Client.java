package com.sowamaciej.BackendApplication.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Client {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String birthDate;
    @NotNull
    private String sex;
    @NotNull
    private String pesel;

    public Client() {
    }

    public Client(Long id, String name, String lastName, String birthDate, String sex, String pesel) {
        this.id = id;
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

    public String getBirthDate() {
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
