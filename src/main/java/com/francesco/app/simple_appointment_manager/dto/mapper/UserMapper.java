package com.francesco.app.simple_appointment_manager.dto.mapper;

import com.francesco.app.simple_appointment_manager.dto.UserDTO;
import com.francesco.app.simple_appointment_manager.dto.UserRequestDTO;
import com.francesco.app.simple_appointment_manager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Map a User in a UserRequestDTO
     */
    UserRequestDTO toCreateUserDTO(User userData);

    /**
     * Map a User in a UserDTO
     * @param userData
     * @return
     */
    UserDTO toUserDTO(User userData);

    /**
     * Map a DTO in a User Entity ignoring his ID
     * @param userData
     * @return an User
     */
    User toCreateUserEntity(UserRequestDTO userData);

    /**
     * Map a list of users in a list of UserDTO
     * @param users
     * @return a list of users mapped in a DTO
     */
    List<UserDTO> toUserDTOList(List<User> users);
}
