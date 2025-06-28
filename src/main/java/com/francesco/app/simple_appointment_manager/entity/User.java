package com.francesco.app.simple_appointment_manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    /**
     * Username for the entity
     * @nullable = false
     * @lenght = max length is 255
     */
    @Column(nullable = false, length = 255)
    private String username;

    /**
     * Email for the entity
     * Cannot be null and it has to be unique
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * List of appointment of the User mapped
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
