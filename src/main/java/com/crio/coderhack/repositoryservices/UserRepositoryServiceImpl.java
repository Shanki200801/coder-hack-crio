package com.crio.coderhack.repositoryservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.crio.coderhack.entities.User;
import com.crio.coderhack.exceptions.InvalidEntriesException;
import com.crio.coderhack.exceptions.UserNotFoundException;
import com.crio.coderhack.repositories.UserRepository;
import com.mongodb.DuplicateKeyException;

import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User addUser(String username, String userId) {
        
        if(username == null || username.isEmpty()){
            throw new InvalidEntriesException("Username cannot be empty");
        }
        if(userId == null || userId.isEmpty()){
            throw new InvalidEntriesException("UserId cannot be empty");
        }
        if(userRepository.existsById(userId)){
            throw new InvalidEntriesException("User already exists");
        }
        
        User user = new User(username, userId);
        
        userRepository.save(user);
       
        return user;
    }

    @Override
    public User removeUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
        userRepository.deleteById(userId);
        return user;
     
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.sort((u1,u2)-> u1.getScore()-u2.getScore());
        return users;
    }
    
    @Override
    public User findUserById(String userId){
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
    }
    
    @Override
    public String dropAllUsers(){
        String status = "Could not delete data";
        try{
        mongoTemplate.dropCollection(User.class);
        status = "Deleted all data";
        }
        catch(Exception e){
            throw new UserNotFoundException(status);
        }
        return status;
    }
}
