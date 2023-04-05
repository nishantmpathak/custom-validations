package com.form.validationdemo.validator;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<ValidDate, String> {
    private String format;
    private String message;
    private boolean allowEmpty;
    @Override
    public void initialize(ValidDate constraintAnnotation) {
        format = constraintAnnotation.format();
        message = constraintAnnotation.message();
        allowEmpty = constraintAnnotation.allowEmpty();
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext ctx) {
        if(allowEmpty && StringUtils.isEmpty(date)){
            return true;
        }
        if(!allowEmpty && StringUtils.isEmpty(date)){
            return false;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate dateToBeValidated = LocalDate.parse(date, formatter);
        }
        catch (DateTimeParseException ex){
            return false;
        }
        return true;
    }
}
