package com.dmm.xamalanche.utils.exceptions;

public class ServiceErrorMessage {

    private String message;

    public ServiceErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
