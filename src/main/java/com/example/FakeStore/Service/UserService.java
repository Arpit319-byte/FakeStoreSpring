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

        logger.info("Fetching all users from the UserService Layer");
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream().map(MapperClass::mapToUserDTO).toList();
        logger.info("Fetched {} users from the UserService Layer", userDTOs.size());
        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Long id) throws IOException {
        logger.info("Fetching user by ID from the UserService Layer");
        User user = userRepository.findById(id).orElseThrow(() -> new IOException("User not found for ID: " + id));
        return MapperClass.mapToUserDTO(user);
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
        logger.info("Deleting user by ID from the UserService Layer");
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) throws IOException {
        logger.info("Updating user by ID from the UserService Layer");

        User user = userRepository.findById(id).orElseThrow(() -> new IOException("User not found for ID: " + id));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        return MapperClass.mapToUserDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getLimitedUsers(int limit) throws IOException {
        logger.info("Fetching limited users from the UserService Layer with limit: {}", limit);
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = users.stream().map(MapperClass::mapToUserDTO).toList();
        List<UserDTO> limitedUsers = userDTOs.subList(0, limit);
        logger.info("Fetched {} limited users from the UserService Layer", limitedUsers.size());
        return limitedUsers;
    }
}
