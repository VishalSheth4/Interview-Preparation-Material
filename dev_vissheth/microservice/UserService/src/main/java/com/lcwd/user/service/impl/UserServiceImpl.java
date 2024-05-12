package com.lcwd.user.service.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.execptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepository;
    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userrepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userrepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id not found on Server"+userId));
    }
}
