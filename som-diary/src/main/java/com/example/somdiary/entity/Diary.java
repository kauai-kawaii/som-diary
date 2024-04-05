package com.example.somdiary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "diary_id")
    private Long diaryId;

    // 회원 -> 다이어리 1:N
    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private User userId;

    @Column(name = "diary_photo")
    private String diaryPhoto;

    // 날짜
    @Column(name = "diary_date")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate diaryDate;

}