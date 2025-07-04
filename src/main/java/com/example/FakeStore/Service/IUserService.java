package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface IUserService {
     List<UserDTO> getAllUsers() throws IOException;
}
