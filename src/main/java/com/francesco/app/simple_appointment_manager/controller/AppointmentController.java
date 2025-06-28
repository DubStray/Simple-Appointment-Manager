package com.francesco.app.simple_appointment_manager.controller;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;
import com.francesco.app.simple_appointment_manager.service.appointment.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/allAppointments")
    public List<AppointmentDTO> allAppointments() {
        return service.findAllAppointment();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id) {
        return service.findAppointmentById(id);
    }

    @PostMapping("/createAppointment")
    public AppointmentDTO createAppointment(@RequestBody AppointmentRequestDTO appointmentData) {
        return service.createAppointment(appointmentData);
    }

    @PutMapping("/updateAppointment/{id}")
    public AppointmentDTO updateAppointment(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointment) {
        return service.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
    }
}
