package com.accumenta.Knowledge_Hub_Portal.globalexception;


import com.accumenta.Knowledge_Hub_Portal.exception.ApproveUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.exception.SubmitUrlAlreadyExceptionExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
    public  class GlobalExceptionHandler {

        @ExceptionHandler (SubmitUrlAlreadyExceptionExists.class)
        public ResponseEntity<?> handleSubmitUrlNotFoundException(SubmitUrlAlreadyExceptionExists ex, WebRequest request) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
