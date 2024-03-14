package com.crio.coderhack.repositoryservices;

import org.springframework.stereotype.Service;

import com.crio.coderhack.entities.User;
import java.util.List;

@Service
public interface UserRepositoryService {
    public User addUser(String username, String userId);
    public User removeUser(String userId);
    public List<User> getAllUsers();
    public User findUserById(String userId);
    public String dropAllUsers();
}