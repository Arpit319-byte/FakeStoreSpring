package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserGateway {

    // Fetches all users
    List<UserDTO> getAllUsers() throws IOException;

    // Fetches a user by their ID
    UserDTO getUserById(Long id) throws IOException;

    // Creates a new user
    UserDTO createUser(UserDTO userDTO) throws IOException;
}
