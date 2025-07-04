package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserGateway {
    List<UserDTO> getAllUsers() throws IOException;
}
