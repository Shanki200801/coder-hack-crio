package com.crio.coderhack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.coderhack.entities.Badge;
import com.crio.coderhack.entities.User;
import com.crio.coderhack.exceptions.UserNotFoundException;
import com.crio.coderhack.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User updateUserScore(int userId, int score) {
        if(score < 0){
            throw new IllegalArgumentException("Score cannot be negative");
        }


        User user = userRepository.findById(Integer.toString(userId)).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setScore(score);
        user = updateBadges(user);
        userRepository.save(user);
        return user;
    }

    private User updateBadges(User user){
        int score = user.getScore();
        if(score > 60){
            Badge[] badgeSet = {Badge.CODE_NINJA, Badge.CODE_CHAMP, Badge.CODE_MASTER};
            user.setBadges(badgeSet);
        }else if(score > 30){
            Badge[] badgeSet = {Badge.CODE_NINJA, Badge.CODE_CHAMP};
            user.setBadges(badgeSet);
        }
        else if(score > 1){
            Badge[] badgeSet = {Badge.CODE_NINJA};
            user.setBadges(badgeSet);
        }
        else{
            Badge[] badgeSet = {};
            user.setBadges(badgeSet);
        }
        return user;

    }


    
}
