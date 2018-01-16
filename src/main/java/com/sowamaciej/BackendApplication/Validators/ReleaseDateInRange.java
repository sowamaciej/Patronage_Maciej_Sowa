package com.sowamaciej.BackendApplication.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ReleaseDateInRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReleaseDateInRange {
    String message() default "validation.release.registration.date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String min() default "01/01/1900";

    String max() default "31/12/2300";
}
