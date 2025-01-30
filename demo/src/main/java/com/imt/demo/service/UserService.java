package com.imt.demo.service;

import com.imt.demo.dao.UserDao;
import com.imt.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private final UserDao UserDao;

    public UserService(UserDao Userdao) {
        this.UserDao = Userdao;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        UserDao.findAll().forEach(users::add);

        return users;
    }
}
