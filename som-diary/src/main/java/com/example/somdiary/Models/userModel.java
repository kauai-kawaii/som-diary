package com.example.somdiary.Models;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Data
public class UserModel {
    @Id
    @ManyToOne
    @Column(name = "user_id")
    private int userId;

    // User Identifier
    // Social Login API would be used
    @Column(name = "user_name")
    private String userName;

}