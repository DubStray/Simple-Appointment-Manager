package com.francesco.app.simple_appointment_manager.service.user;

import com.francesco.app.simple_appointment_manager.dto.UserDTO;
import com.francesco.app.simple_appointment_manager.dto.UserRequestDTO;
import com.francesco.app.simple_appointment_manager.dto.mapper.UserMapper;
import com.francesco.app.simple_appointment_manager.entity.User;
import com.francesco.app.simple_appointment_manager.exception.user.DuplicateUserException;
import com.francesco.app.simple_appointment_manager.exception.user.UserNotFoundException;
import com.francesco.app.simple_appointment_manager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserMapper mapper;

    /**
     * Injecting dependencies via constructor
     * @param userRepo
     * @param mapper
     */
    public UserServiceImpl(UserRepository userRepo, UserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    /**
     * Method for CRUD <br/>
     * Finds all users
     * @return list of users
     */
    @Override
    public List<UserDTO> findAllUsers() {
        return mapper.toUserDTOList(userRepo.findAll());
    }

    /**
     * Finds a user by his ID.
     * @param id
     * @return User
     */
    @Override
    public UserDTO findUserById(Long id) {
        return mapper.toUserDTO(userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    /**
     * Finds a user by his EMAIL
     * @param email
     * @return User
     */
    @Override
    public UserDTO findUserByEmail(String email) {
        return mapper.toUserDTO(userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email)));
    }

    /**
     * Create a User and check if it's not duplicated
     * @param userData
     * @return UserDTO
     */
    @Override
    public UserDTO createUser(UserRequestDTO userData) {
        Optional<User> checkUser = userRepo.findByEmail(userData.getEmail());
        if (checkUser.isPresent()) {
            throw new DuplicateUserException(userData.getEmail());
        }

        return mapper.toUserDTO(userRepo.save(mapper.toCreateUserEntity(userData)));
    }

    /**
     * Update an existing user
     * @param id
     * @param userRequestDTO
     * @return UserDTO
     */
    @Override
    public UserDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User checkUser = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        return mapper.toUserDTO(userRepo.save(checkUser));
    }

    /**
     * Delete a User by his id
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        userRepo.delete(user);
    }
}
