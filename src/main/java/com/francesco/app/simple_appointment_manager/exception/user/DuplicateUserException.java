package com.francesco.app.simple_appointment_manager.exception.user;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String email) {
        super("User with [" + email + "] email already exist.");
    }

    public DuplicateUserException(Long id) {
        super("User with [" + id + "] ID already exist.");
    }
}
