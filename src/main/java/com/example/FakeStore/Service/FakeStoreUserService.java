package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Gateway.FakeStoreUserGateway;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreUserService implements IUserService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreUserService.class);
    private final FakeStoreUserGateway userGateway;

    public FakeStoreUserService(FakeStoreUserGateway _userGateway) {
        this.userGateway = _userGateway;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        // This method fetches all users from the user gateway layer
        logger.info("Fetching all users from the FakeStoreUserService Layer");
        return userGateway.getAllUsers();
    }

    @Override
    public UserDTO getUserById(Long id) throws IOException {
        // This method fetches a user by their ID
        logger.info("Fetching user by ID from the FakeStoreUserService Layer");
        return userGateway.getUserById(id);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws IOException {
        // This method creates a new user
        logger.info("Creating a new user in the FakeStoreUserService Layer");
        UserDTO createdUser = userGateway.createUser(userDTO);
        if (createdUser == null) {
            logger.error("Failed to create user: {}", userDTO);
            return null; // If the user creation fails, return null
        }
        return createdUser; // Return the created user
    }

    @Override
    public boolean deleteUserById(Long id) throws IOException {
        // This method deletes a user by their ID
        logger.info("Deleting user by ID from the FakeStoreUserService Layer");
        boolean isDeleted = userGateway.deleteUserById(id);
        if (isDeleted) {
            logger.info("User with ID {} deleted successfully", id);
        } else {
            logger.error("Failed to delete user with ID {}", id);
        }
        return isDeleted; // Return true if deletion was successful, false otherwise
    }
}
