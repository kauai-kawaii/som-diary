package com.example.somdiary.repository;

import com.example.somdiary.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    // Find user by username
    User findByUserName(String username);

    // Find user by user id
    User findById(User userId);
}
