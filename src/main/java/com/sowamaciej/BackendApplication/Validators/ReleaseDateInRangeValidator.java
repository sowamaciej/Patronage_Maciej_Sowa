package com.sowamaciej.BackendApplication.Validators;

import com.sowamaciej.BackendApplication.Models.Car;

import javax.servlet.http.HttpServlet;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReleaseDateInRangeValidator implements ConstraintValidator<ReleaseDateInRange, Car> {

    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");

    private ReleaseDateInRange releaseDateInRange;


    @Override
    public void initialize(ReleaseDateInRange ReleaseDateInRange) {
        this.releaseDateInRange=releaseDateInRange;
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Date min = car.getDateOfFirstRegistration();
            final Date max = new Date();
            return  (car.getRegistrationReleaseDate().after(min) && car.getRegistrationReleaseDate().before(max));

        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
    }
}
