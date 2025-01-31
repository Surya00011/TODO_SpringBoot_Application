package com.todolist.ToDo.Application.HandleException;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Handles Exception if validation failed
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        
        List<ObjectError> output = ex.getBindingResult().getAllErrors();
        HashMap<String, String> errorMap = new HashMap<>();
        
        for (ObjectError error : output) {
            String errorField = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(errorField, errorMessage);
        }

        // Return a BAD_REQUEST response with the error details
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
    
}
