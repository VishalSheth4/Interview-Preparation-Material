package com.lcwd.user.service.service;

import com.lcwd.user.service.entities.User;
import java.util.*;
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    //TODO : delete
    //UPDATE
    //Add data
}
