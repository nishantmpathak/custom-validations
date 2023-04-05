package com.form.validationdemo.controller;

import com.form.validationdemo.exceptionhandler.BindingResultProcessor;
import com.form.validationdemo.model.Form;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FormController {

    @Autowired
    BindingResultProcessor bindingResultProcessor;

    @PostMapping(value = "/form")
    public ResponseEntity<Form> submitForm(@Valid @RequestBody Form form, BindingResult result) throws BindException {
        if(result.hasErrors()){
            bindingResultProcessor.process(result);
        }
        System.out.println("form is "+form.toString());
        return new ResponseEntity<>(form, HttpStatus.CREATED);
    }
}
