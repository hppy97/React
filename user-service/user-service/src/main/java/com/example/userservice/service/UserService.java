package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> findAll() {
        List<User> users=new ArrayList<User>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public User createUser(User user) {
        userRepo.save(user);
    }
}
