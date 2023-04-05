package com.form.validationdemo.exceptionhandler;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@Component
public class BindingResultProcessor {
    public void process(BindingResult result) throws BindException {
        throw new BindException(result);
    }
}
