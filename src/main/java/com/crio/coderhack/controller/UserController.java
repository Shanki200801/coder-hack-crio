package com.crio.coderhack.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.coderhack.dtos.UpdateScoreDto;
import com.crio.coderhack.entities.User;
import com.crio.coderhack.repositoryservices.UserRepositoryService;
import com.crio.coderhack.services.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@RestController
@Slf4j
@RequestMapping("/")
public class UserController {
    public static final String USER_API_ENDPOINT = "users";
    public static final String ADD_USER_API_ENDPOINT = "addUser";
    public static final String REMOVE_USER_API_ENDPOINT = "removeUser";
    public static final String UPDATE_SCORE_API_ENDPOINT  = "updateScore";

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private UserService userService;

    @GetMapping(USER_API_ENDPOINT)
    public List<User> getAllUsers() {
        return userRepositoryService.getAllUsers();
    }

    @GetMapping(USER_API_ENDPOINT+"/{userId}")
    public User getParticularUser( @PathVariable String userId) {
        return userRepositoryService.findUserById(userId);
    }

    @PostMapping(USER_API_ENDPOINT)
    public User addUserToDB(@RequestBody User entity) {
        userRepositoryService.addUser(entity.getUsername(), entity.getUserId());
        return entity;
    }

    @PutMapping(USER_API_ENDPOINT+"/{userId}")
    public User UpdateUserScore(@PathVariable String userId, @RequestBody UpdateScoreDto entity) {
        return userService.updateUserScore(Integer.parseInt(userId),entity.getScore());
    }

    @DeleteMapping(USER_API_ENDPOINT+"/{userId}")
    public User DeleteUserFromDB(@PathVariable String userId) {
        return userRepositoryService.removeUser(userId);
    }

    @GetMapping("/dropAllUsers")
    public String getMethodName() {
        return userRepositoryService.dropAllUsers();
    }
    
    
    
    
    

    
}
