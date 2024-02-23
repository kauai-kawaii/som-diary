package com.example.somdiary.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class DiaryModel {
    @Id
    @Column(name = "diary_id")
    int diaryId;

    @OneToMany(mappedBy = "userId")
    @Column(name = "user_id_fk")
    DiaryModel userIdFk;

    @OneToMany(mappedBy = "trackId")
    @Column(name = "track_id_fk")
    TrackModel trackIdFk;

    @Column(name = "diary_date")
    LocalDate diaryDate;

    @Column(name = "diary_photo")
    String diaryPhoto;

    @Column(name = "diary_feeling")
    String diaryFeeling;

    @Column(name = "diary_latitude")
    String diaryLatitude;

    @Column(name = "diary_longitude")
    String diaryLongitude;

    @Column(name = "diary_visit_rate")
    String diaryVisitRate;
}
