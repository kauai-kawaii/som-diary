package com.example.somdiary.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "diary")
public class DiaryModel {
    @Id
    @Column(name = "diary_id")
    int diaryId;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    UserModel userIdFk;

    @ManyToOne
    @JoinColumn(name = "track_id_fk")
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

    // Empty constructor
    public DiaryModel() {
    }

    // Full Contructor
    public DiaryModel(int diaryId, UserModel userIdFk, TrackModel trackIdFk, LocalDate diaryDate, String diaryPhoto,
            String diaryFeeling, String diaryLatitude, String diaryLongitude, String diaryVisitRate) {
        this.diaryId = diaryId;
        this.userIdFk = userIdFk;
        this.trackIdFk = trackIdFk;
        this.diaryDate = diaryDate;
        this.diaryPhoto = diaryPhoto;
        this.diaryFeeling = diaryFeeling;
        this.diaryLatitude = diaryLatitude;
        this.diaryLongitude = diaryLongitude;
        this.diaryVisitRate = diaryVisitRate;
    }
}
