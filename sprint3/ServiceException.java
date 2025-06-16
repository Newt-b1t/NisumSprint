package com.avinash.sprint3;

// 1️⃣ Define a custom ServiceException
public class ServiceException extends Exception {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
