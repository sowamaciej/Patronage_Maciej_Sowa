package com.sowamaciej.BackendApplication.Validators;

import javax.servlet.http.HttpServlet;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInRangeValidator implements ConstraintValidator<DateInRange, java.util.Date> {

    private final SimpleDateFormat dateParser = new SimpleDateFormat("dd/mm/yyyy");

    private DateInRange dateInRange;


    @Override
    public void initialize(DateInRange dateInRange) {
        this.dateInRange = dateInRange;
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Date min = dateParser.parse("01/01/1900");
            final Date max = new Date();
            return date == null || (date.after(min) && date.before(max));

        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
