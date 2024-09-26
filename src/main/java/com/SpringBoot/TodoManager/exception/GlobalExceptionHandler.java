package com.SpringBoot.TodoManager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerExceptionHandler(NullPointerException ex){
        logger.error("Error : {} ",ex.getMessage());

        return ResponseEntity.internalServerError().body(ex.getMessage()+"Generated from the global exception Handler ");
    }
   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseHandler> NotFoundExceptionHandler(ResourceNotFoundException ex){
        logger.error("ERROR : {} ",ex.getMessage());
        ExceptionResponseHandler exceptionResponseHandler= new ExceptionResponseHandler();
        exceptionResponseHandler.setMessage(ex.getMessage());
        exceptionResponseHandler.setStatus(ex.getStatus());
        exceptionResponseHandler.setSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseHandler);

    }



}
