package com.example.somdiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainPhotoDto {
    private Long diaryId;
    private String userId;
    private String diaryPhoto;
    private int year;
    private int month;
    private int date;

    @Override
    public String toString() {
        return "MainPhotoDto{" +
                "diaryId=" + diaryId +
                ", userId='" + userId + '\'' +
                ", diaryPhoto='" + diaryPhoto + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", date=" + date +
                '}';
    }
}
