package com.francesco.app.simple_appointment_manager.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with ID: [" + id + "] not found.");
    }

    public UserNotFoundException(String email) {
        super("User with EMAIL: [" + email + "] not found.");
    }
}
