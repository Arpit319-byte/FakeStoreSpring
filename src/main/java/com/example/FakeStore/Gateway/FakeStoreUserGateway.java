package com.example.FakeStore.Gateway;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.example.FakeStore.DTO.FakeStoreSingleUserResponseDTO;
import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreUserApi;

@Component
public class FakeStoreUserGateway implements IUserGateway {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreUserGateway.class);
    private final FakeStoreUserApi fakeStoreUserApi;

    public FakeStoreUserGateway(FakeStoreUserApi _fakeStoreUserApi) {
        this.fakeStoreUserApi = _fakeStoreUserApi;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        logger.info("Fetching the User list from the GatewayLayer");
        FakeStoreUserResponseDTO response = fakeStoreUserApi.getAllUsers().execute().body();

        // Check if the response is null or if it contains a null user list
        if (response == null) {
            logger.error("Failed to fetch users from the API or received null response");
            return List.of(); // Return an empty list if the response is null
        }

        // Check if the user list is null or empty
        if (response.getUsers() == null) {
            logger.info(response.getStatus());
            logger.info(response.getMessage());
            logger.error("No users found in the response");
            return List.of(); // Return an empty list if no users are found
        }

        return response.getUsers().stream().map(
                        user -> UserDTO.builder()
                                .email(user.getEmail())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .firstName(user.getFirstName())
                                .address(user.getAddress())
                                .phone(user.getPhone())
                                .build())
                .toList();

    }

    @Override
    public UserDTO getUserById(Long id) throws IOException {
        logger.info("Fetching user by ID from the GatewayLayer");
        FakeStoreSingleUserResponseDTO response = fakeStoreUserApi.getUserById(id).execute().body();

        // Check if the response is null or if it contains a null user
        if (response == null || response.getUser() == null) {
            logger.error("Failed to fetch user with ID {} from the API or received null response", id);
            return null; // Return null if the response is null
        }
        return response.getUser();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws IOException {
        logger.info("Creating a new user in the GatewayLayer");
        FakeStoreSingleUserResponseDTO response = fakeStoreUserApi.createUser(userDTO).execute().body();

        // Check if the response is null or if it contains a null user
        if (response == null || response.getUser() == null) {
            logger.error("Failed to create user or received null response");
            return null; // Return null if the response is null
        }
        return response.getUser();
    }

    @Override
    public boolean deleteUserById(Long id) throws IOException {
        logger.info("Deleting user by ID from the GatewayLayer");
        FakeStoreUserResponseDTO response= fakeStoreUserApi.deleteUserById(id).execute().body();

        // Check if the response is null or if it contains a null user
        if (response == null ){
            logger.error("Failed to delete user with ID {} or received null response", id);
            return false; // Return false if the response is null
        }

        return true; // Return true if the deletion was successful
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) throws IOException {
        logger.info("Updating user with ID {} in the GatewayLayer", id);
        FakeStoreSingleUserResponseDTO response = fakeStoreUserApi.updateUserById(id, userDTO).execute().body();

        // Check if the response is null or if it contains a null user
        if (response == null || response.getUser() == null) {
            logger.error("Failed to update user with ID {} or received null response", id);
            return null; // Return null if the response is null
        }

        return response.getUser(); // Return the updated user
    }

    @Override
    public List<UserDTO> getLimitedUsers(int limit) throws IOException {
        logger.info("Fetching limited users from the GatewayLayer with limit: {}", limit);
        FakeStoreUserResponseDTO response = fakeStoreUserApi.getLimitedUsers(limit).execute().body();

        // Check if the response is null or if it contains a null user list
        if (response == null || response.getUsers() == null) {
            logger.error("Failed to fetch limited users or received null response");
            return List.of(); // Return an empty list if the response is null
        }

        return response.getUsers().stream().map(
                        user -> UserDTO.builder()
                                .email(user.getEmail())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .firstName(user.getFirstName())
                                .address(user.getAddress())
                                .phone(user.getPhone())
                                .build())
                .toList();
    }
}
