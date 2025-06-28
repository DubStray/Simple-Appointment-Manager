package com.francesco.app.simple_appointment_manager.service.appointment;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> findAllAppointment();
    AppointmentDTO findAppointmentById(Long id);
    AppointmentDTO createAppointment(AppointmentRequestDTO appointment);
    AppointmentDTO updateAppointment(Long id, AppointmentRequestDTO appointment);
    void deleteAppointment(Long id);
}
