package com.example.somdiary.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class diaryModel {
    @Id
    int diary_id;
    @OneToMany(mappedBy = "user_id")
    diaryModel user_id_fk;
    @OneToMany(mappedBy = "track_id")
    trackModel track_id_fk;
    LocalDate diary_date;
    String diary_photo;
    String diary_feeling;
    String diary_latitude;
    String diary_longitude;
    String diary_visit_rate;
    String diary_title;
    String diary_writing;
    String diary_weather;

}
