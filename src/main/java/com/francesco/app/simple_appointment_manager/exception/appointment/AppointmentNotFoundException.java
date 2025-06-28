package com.francesco.app.simple_appointment_manager.exception.appointment;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(Long id)
    {
        super("Appointment with ID: [" + id + "] not found.");
    }
}
