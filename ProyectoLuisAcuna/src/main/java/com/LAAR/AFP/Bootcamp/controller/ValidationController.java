package com.LAAR.AFP.Bootcamp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationController {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidateExceptions(MethodArgumentNotValidException ex)
    {
           Map<String, String> errors = new HashMap<String, String>();
           ex.getBindingResult().getAllErrors().forEach((error) -> {
               String filedName = ((FieldError) error).getField();
               String message = error.getDefaultMessage();

               errors.put(filedName, message);
           });
           return errors;
    }

}
