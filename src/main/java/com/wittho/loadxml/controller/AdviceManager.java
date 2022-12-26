package com.wittho.loadxml.controller;

import com.wittho.loadxml.commons.DataError;
import com.wittho.loadxml.commons.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceManager {

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<DataError> handlerNotFound(NotFoundException exception) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(DataError.createDataError(exception.getMessage()));
  }
}
