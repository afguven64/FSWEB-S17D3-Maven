package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ZooGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handle(ZooException exception) {
        ZooErrorResponse error = new ZooErrorResponse(exception.getHttpStatus().value(),
                exception.getLocalizedMessage(), System.currentTimeMillis());
        log.error("Exception occured = ", exception);

        return new ResponseEntity<>(error, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handle(Exception exception) {
        ZooErrorResponse error = new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getLocalizedMessage(), System.currentTimeMillis());
        log.error("Exception occured = ", exception);

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
