package com.hackathon.paymentsservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(DataNotFoundException.class)
    public @ResponseBody  ResponseEntity<?> DataNotFoundException(DataNotFoundException e) {
            return new ResponseEntity<>(new ErrorInfo(LocalDateTime.now(), e.getMessage()),HttpStatus.NOT_FOUND);
    } 
    
}