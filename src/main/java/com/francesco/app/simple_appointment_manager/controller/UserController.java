package com.francesco.app.simple_appointment_manager.controller;

import com.francesco.app.simple_appointment_manager.dto.UserDTO;
import com.francesco.app.simple_appointment_manager.dto.UserRequestDTO;
import com.francesco.app.simple_appointment_manager.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/allUsers")
    public List<UserDTO> allUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @PostMapping("/createUser")
    public UserDTO createUser(@Valid @RequestBody UserRequestDTO userData) {
        return service.createUser(userData);
    }

    @PutMapping("/updateUser/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userData) {
        return service.updateUser(id, userData);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
