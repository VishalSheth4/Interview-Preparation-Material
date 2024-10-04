package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;
    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getsingleUser(@PathVariable String userId){
        User user1 = userService.getUser(userId);
        return ResponseEntity.ok (user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user1 = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
}
