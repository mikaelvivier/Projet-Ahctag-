package com.imt.demo;

import com.imt.demo.config.JwtGeneratorInterface;
import com.imt.demo.controller.UserController;
import com.imt.demo.exception.UserNotFoundException;
import com.imt.demo.model.User;
import com.imt.demo.service.JwtService;
import com.imt.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private JwtGeneratorInterface jwtGenerator;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserController userController;

    @Test
    void shouldRegisterUserSuccessfully() {
        User user = new User("Mikael", "azerty");

        ResponseEntity<?> response = userController.postUser(user);

        assertEquals(CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void shouldFailLoginWithInvalidCredentials() {
        User user = new User("Baptiste", "prout");

        ResponseEntity<?> response = userController.loginUser(user);

        assertEquals(CONFLICT, response.getStatusCode());
        assertEquals("UserName or Password is Invalid", response.getBody());
    }
}
