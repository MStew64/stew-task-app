package com.stewm.task.controller;


import com.stewm.task.domain.dto.ErrorDTO;
import com.stewm.task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex){

        String error = ex.getBindingResult().getFieldErrors().stream().findFirst().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation Failed");

        ErrorDTO errorDTO = new ErrorDTO(error);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTaskNotFoundException(TaskNotFoundException ex){

        UUID taskNotFoundID = ex.getId();
        String error = String.format("Task with ID %s not found",taskNotFoundID);
        ErrorDTO errorDTO = new ErrorDTO(error);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
