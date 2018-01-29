package com.sowamaciej.BackendApplication.Controllers;


import com.sowamaciej.BackendApplication.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "CAR NOT FOUND")
    public void handleCarNotFoundException(CarNotFoundException e) {
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "CLIENT NOT FOUND")
    public void handleClientNotFoundException(ClientNotFoundException e) {
    }


}
