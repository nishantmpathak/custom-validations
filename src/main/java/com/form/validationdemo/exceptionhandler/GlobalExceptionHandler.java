package com.form.validationdemo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.form.validationdemo.exceptionhandler.constants.Constants.REQUEST_PARAMETER_ARE_INVALID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleException(MethodArgumentNotValidException ex){
        Map<String , String> error = new HashMap<>();
        System.out.println("Handling error");
        ex.getAllErrors().stream().forEach(er -> {
            String field = ((FieldError)er).getField();
            String message = er.getDefaultMessage();
            error.put(field, message);
        });

        System.out.println(error);
        return error;
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiError> handleBindException(BindException ex){

        ApiError apiError = new ApiError();
        apiError.setErrorId(ApplicationErrorId.ValidationError);
        apiError.setMessage(REQUEST_PARAMETER_ARE_INVALID);
        var bindingResults = ex.getBindingResult();
        bindingResults.getFieldErrors().stream().forEach(error -> apiError.addDetails(error.getObjectName(), error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
