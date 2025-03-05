package com.imt.demo.exception;

public class UserNotFoundException extends RuntimeException {

    // Constructeur sans argument
    public UserNotFoundException() {
        super("User not found");
    }

    // Constructeur avec message
    public UserNotFoundException(String message) {
        super(message);
    }

    // Constructeur avec message et cause
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructeur avec cause seulement
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}