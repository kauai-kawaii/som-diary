package com.example.somdiary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column
    private String userId;

    @Column
    private String userName;

    private String userEmail;

    private String role;
}
