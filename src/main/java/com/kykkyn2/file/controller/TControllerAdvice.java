package com.kykkyn2.file.controller;

import com.kykkyn2.file.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@Slf4j
@ControllerAdvice
public class TControllerAdvice {

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public ResponseEntity handleError1(MultipartException e) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getCause().getMessage());
        errorResponse.setCode("not.support.file.size.exception");

        return new ResponseEntity<>(errorResponse, HttpStatus.PAYLOAD_TOO_LARGE);

    }

}
