package com.myBank.myBankapp.web.controller;

import com.myBank.myBankapp.exception.EmailSendingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = EmailSendingException.class)
    public ResponseEntity<Object> handleEmailSendingException(EmailSendingException ex){
        String errorMsg = "Error ("+ex.getStatusCode()+"): ";
        errorMsg += " - "+ex.getMessage();
        return ResponseEntity.status( ex.getStatusCode()).body(errorMsg);
    }
}
