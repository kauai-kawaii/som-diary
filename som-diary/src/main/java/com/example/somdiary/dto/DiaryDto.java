package com.example.somdiary.dto;

import com.example.somdiary.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DiaryDto {
    private Long diaryId;
    private String userId;
    private String diaryPhoto;
    private LocalDate diaryDate;
    private String diaryFeeling;
    private String diaryLatitude;
    private String diaryLongitude;
    private String diaryVisitRate;
    private String diaryTitle;
    private String diaryWriting;
    private String diaryWeather;
    private String diaryAddress;
    private String diaryAddressName;

    public static DiaryDto createdDiaryDto(Diary diary) {
        return new DiaryDto(
                diary.getDiaryId(),
                diary.getUser().getId(),
                diary.getDiaryPhoto(),
                diary.getDiaryDate(),
                diary.getDiaryFeeling(),
                diary.getDiaryLatitude(),
                diary.getDiaryLongitude(),
                diary.getDiaryVisitRate(),
                diary.getDiaryTitle(),
                diary.getDiaryWriting(),
                diary.getDiaryWeather(),
                diary.getDiaryAddress(),
                diary.getDiaryAddressName()
        );
    }
    public DiaryDto toEntity() {
        return new DiaryDto(diaryId, userId, diaryPhoto,diaryDate, diaryFeeling, diaryLatitude, diaryLongitude, diaryVisitRate, diaryTitle, diaryWriting, diaryWeather, diaryAddress, diaryAddressName);
    }
}