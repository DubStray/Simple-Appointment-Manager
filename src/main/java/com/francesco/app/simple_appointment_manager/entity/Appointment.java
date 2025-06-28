package com.francesco.app.simple_appointment_manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseEntity {

    /**
     * Date and Time for the appointment
     */
    private LocalDateTime DateTime;

    /**
     * Relation to the user
     */
    @ManyToOne
    private User user;
}
