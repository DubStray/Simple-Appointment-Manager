package com.francesco.app.simple_appointment_manager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {

    @NotBlank
    private LocalDateTime dateTime;

    @NotBlank
    private UserDTO userInfo;
}
