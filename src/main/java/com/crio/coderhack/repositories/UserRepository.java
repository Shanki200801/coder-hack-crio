package com.crio.coderhack.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crio.coderhack.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findByUserId(String userId);
    boolean existsByUserId(String userId);
}
