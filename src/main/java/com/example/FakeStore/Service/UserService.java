package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Mapper.MapperClass;
import com.example.FakeStore.Repository.UserRepository;
import com.example.FakeStore.model.User;
import org.apache.catalina.mapper.Mapper;
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

        if (userDTO == null) {
            logger.error("UserDTO is null, cannot create user");
            return null; // If the userDTO is null, return null
        }
        User createdUser = userRepository.save(MapperClass.mapToUserEntity(userDTO));
        return MapperClass.mapToUserDTO(createdUser); // Return the created user
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
