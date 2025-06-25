package com.francesco.app.simple_appointment_manager.repository;

import com.francesco.app.simple_appointment_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Take an Email as parameter thanks to JPA to find a User
     * with that email.
     * Optional is used to be null-safe
     * @param Email
     * @return User with matching email
     */
    Optional<User> findByEmail(String Email);
}
