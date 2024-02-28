package com.example.somdiary.Models;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class UserModel {
    @Id
    @Column(name = "user_id")
    private int userId;

    // User Identifier
    // Social Login API would be used
    @Column(name = "user_name")
    private String userName;

    // Foreign Key
    @OneToMany(mappedBy = "userIdFk")
    private List<DiaryModel> diary;

    // Empty and Full Contructors
    public UserModel() {
    }

    public UserModel(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}