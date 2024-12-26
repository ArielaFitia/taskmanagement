package com.ditto.taskmanagement.service;

import com.ditto.taskmanagement.model.User;
import com.ditto.taskmanagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService; // Use the interface

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository); // Provide the concrete implementation
    }

    @Test
    public void testGetUserById() {
        // Arrange: Create a mock user and simulate repository behavior
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John Doe");
        mockUser.setEmail("john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Act: Call the service method
        User user = userService.getUserById(1L);

        // Assert: Verify the result
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    public void testCreateUser() {
        // Arrange: Simulate saving a user
        User newUser = new User();
        newUser.setName("Jane Doe");
        newUser.setEmail("jane@example.com");
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // Act: Call the service method
        User savedUser = userService.createUser(newUser);

        // Assert: Verify the result
        assertEquals("Jane Doe", savedUser.getName());
    }
}


