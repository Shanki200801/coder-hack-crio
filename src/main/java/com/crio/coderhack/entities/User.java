package com.crio.coderhack.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class User {
    private String username;
    // @Indexed(unique = true)
    @Id
    private String userId;
    private int score;
    private Badge[] badges;

    // @JsonIgnore
    // private final int MAX_BADGES = 3;

    public User(String username, String userId, int score, Badge[] badges) {
        this.username = username;
        this.userId = userId;
        this.score = score;
        this.badges = badges;
    }

    public User(String username, String userId) {
        this.username = username;
        this.userId = userId;
        this.score = 0;
        this.badges = new Badge[3];
    }

}
