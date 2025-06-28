package com.francesco.app.simple_appointment_manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    /**
     * Validation for the username <br/>
     * Cannot be blank
     * 
     * @Size Custom size and message when it exceeds the allowed size
     */
    @NotBlank
    @Size(max = 255, message = "Max length allowed: 255")
    private String username;

    /**
     * Validation for the email
     * 
     * @Email validates the email through a syntax check
     * @Size Custom size and message when it exceeds the allowed size
     */
    @NotBlank
    @Email(message = "Email not valid.")
    @Size(max = 255, message = "Max length allowed: 255")
    private String email;
}
