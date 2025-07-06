package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface IUserService {

    // Fetches all users from the user gateway layer
    List<UserDTO> getAllUsers() throws IOException;

    // Fetches a user by their ID
    UserDTO getUserById(Long id) throws IOException;

    UserDTO createUser(UserDTO userDTO) throws IOException;

}
