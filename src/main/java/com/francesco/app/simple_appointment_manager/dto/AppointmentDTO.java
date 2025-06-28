package com.francesco.app.simple_appointment_manager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private LocalDateTime dateTime;
    private UserDTO userInfo;
}
