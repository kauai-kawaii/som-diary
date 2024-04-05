package com.example.somdiary.repository;

import com.example.somdiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String username);
}

