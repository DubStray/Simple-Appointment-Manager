package com.francesco.app.simple_appointment_manager.service.user;

import com.francesco.app.simple_appointment_manager.dto.UserDTO;
import com.francesco.app.simple_appointment_manager.dto.UserRequestDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long id);
    UserDTO findUserByEmail(String Email);
    UserDTO createUser(UserRequestDTO userData);
    UserDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
}
