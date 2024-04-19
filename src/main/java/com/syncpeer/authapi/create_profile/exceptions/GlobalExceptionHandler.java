package com.syncpeer.authapi.create_profile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmptyImageException.class)
    public ResponseEntity<String> handleEmptyProfileImageException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Internal Server Error: UNKNOWN_SYNC_PEER_ERROR");
    }
}
