package com.example.FakeStore.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Repository.UserRepository;
import com.example.FakeStore.model.User;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User user1;
    private User user2;
    private List<User> userList;
    private List<User> singleUserList;

   
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);

        user1=User.builder().firstName("John").lastName("Doe").email("john.doe@example.com").password("password").phone("1234567890").build();
        user2=User.builder().firstName("Jane").lastName("Doe").email("jane.doe@example.com").password("password").phone("1234567890").build();
        userList=Arrays.asList(user1,user2);
        singleUserList=Collections.singletonList(user1);
    }
    
    @Test
    void testGetAllUsers() throws IOException {

        when(userRepository.findAll()).thenReturn(userList);
        List<UserDTO> result=userService.getAllUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());
        verify(userRepository, times(1)).findAll();
    }
    
}
