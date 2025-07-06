package com.example.FakeStore.Controller;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Service.IUserService;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

     private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);
     private final IUserService userService;

     public UserController(IUserService _userService) {
         this.userService = _userService;
     }

     @GetMapping
     public ResponseEntity<List<UserDTO>> getAllUsers() throws IOException {
            // This method fetches all users from the user service layer
            logger.info("Fetching all users from the UserController Layer");
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
     }

     @GetMapping("/{id}")
        public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws IOException {
                // This method can be implemented to fetch a user by their ID
                logger.info("Fetching user by ID from the UserController Layer");
                UserDTO user = userService.getUserById(id);
                return ResponseEntity.ok(user);
        }

     @PostMapping
     public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws IOException {

         // This method can be implemented to create a new user
         logger.info("Creating a new user in the UserController Layer");

         UserDTO createdUser = userService.createUser(userDTO);
            if (createdUser == null) {
                logger.error("Failed to create user: {}", userDTO);
                 // If the user creation fails, return a 400 Bad Request response
                return ResponseEntity.status(400).build(); // Bad Request
            }
         return ResponseEntity.status(201).body(createdUser); // Created
     }

     @DeleteMapping("{id}")
     public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws IOException {
         // This method can be implemented to delete a user by their ID
         logger.info("Deleting user by ID from the UserController Layer");
         boolean isDeleted = userService.deleteUserById(id);
         if (isDeleted) {
             return ResponseEntity.ok("User deleted successfully");
         } else {
             return ResponseEntity.status(404).body("User not found");
         }
     }

}
