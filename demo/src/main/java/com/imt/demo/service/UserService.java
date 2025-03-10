package com.imt.demo.service;

import com.imt.demo.exception.UserNotFoundException;
import com.imt.demo.model.User;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}