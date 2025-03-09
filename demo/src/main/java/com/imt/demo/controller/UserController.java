package com.imt.demo.controller;

import com.imt.demo.config.JwtGeneratorImpl;
import com.imt.demo.config.JwtGeneratorInterface;
import com.imt.demo.exception.UserNotFoundException;
import com.imt.demo.model.User;
import com.imt.demo.service.JwtService;
import com.imt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("auth")
public class UserController {
    private UserService userService;
    private JwtGeneratorInterface jwtGenerator;
    private JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtGeneratorInterface jwtGenerator, JwtService jwtService) {
        this.userService=userService;
        this.jwtGenerator=jwtGenerator;
        this.jwtService=jwtService;
    }

    @GetMapping("/validate-token")
    public boolean isTokenValid(@RequestParam String token) {
        return jwtService.isTokenValid(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getUserName() == null || user.getPassword() == null) {
                throw new UserNotFoundException("UserName or Password is Empty");
            }
            User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
            if(userData == null){
                throw new UserNotFoundException("UserName or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}