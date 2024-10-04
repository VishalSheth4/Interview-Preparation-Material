package com.lcwd.user.service.service;

import com.lcwd.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface UserService {
    //User operation

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user
    User getUser(String userId);

    //todo

    //delete
    void deleteUser(String userId);

    String updateUser(String usderId);
}
