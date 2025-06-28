package com.francesco.app.simple_appointment_manager.repository;

import com.francesco.app.simple_appointment_manager.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
