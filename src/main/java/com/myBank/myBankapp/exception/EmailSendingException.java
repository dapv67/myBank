package com.myBank.myBankapp.exception;

public class EmailSendingException extends RuntimeException{

    private int statusCode;
    public EmailSendingException(String message, int statusCode){
        super(message);
        this.statusCode=statusCode;
    }
    public int getStatusCode(){
        return statusCode;
    }
}
