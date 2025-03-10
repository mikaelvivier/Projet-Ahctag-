package com.imt.demo.service;

import com.imt.demo.exception.UserNotFoundException;
import com.imt.demo.model.User;
import com.imt.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUserByNameAndPassword(String name, String password) throws RuntimeException  {
        User user = userRepository.findByUserNameAndPassword(name, password);
        if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
    }
}