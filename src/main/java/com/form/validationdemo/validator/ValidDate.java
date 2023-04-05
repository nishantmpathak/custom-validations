package com.form.validationdemo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateValidator.class} )
public @interface ValidDate {
    String format() default "dd-MM-yyyy";
    String message() default "invalid date provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    boolean allowEmpty();
}
