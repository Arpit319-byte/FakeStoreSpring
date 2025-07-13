package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        return List.of();
    }

    @Override
    public UserDTO getUserById(Long id) throws IOException {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws IOException {
        logger.info("Creating a new user in the UserService Layer");
        UserDTO createdUser = userRepository.save(userDTO);
        if (createdUser == null) {
            logger.error("Failed to create user: {}", userDTO);
            return null; // If the user creation fails, return null
        }
        return createdUser; // Return the created user
    }

    @Override
    public boolean deleteUserById(Long id) throws IOException {
        return false;
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) throws IOException {
        return null;
    }

    @Override
    public List<UserDTO> getLimitedUsers(int limit) throws IOException {
        return List.of();
    }
}
