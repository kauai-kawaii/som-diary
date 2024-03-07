package com.example.somdiary.repository;

import com.example.somdiary.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    User findByUserName(String username);
}

