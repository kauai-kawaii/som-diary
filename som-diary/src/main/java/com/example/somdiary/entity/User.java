package com.example.somdiary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Data
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length=85)
    private String id;

    @Column(name="user_name")
    private String userName;

}