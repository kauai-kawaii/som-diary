package com.example.somdiary.dto;

import com.example.somdiary.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DiaryDto {
    private Long diaryId;
    private String userId;
//    private Long trackId;
    private String diaryPhoto;
    private Date diaryDate;
    private String diaryFeeling;
    private String diaryLatitude;
    private String diaryLongitude;
    private String diaryVisitRate;
    private String diaryTitle;
    private String diaryWriting;
    private String diaryWeather;

    public static DiaryDto createdDiaryDto(Diary diary) {
        return new DiaryDto(
                diary.getDiaryId(),
                diary.getUser().getId(),
//                diary.getTrack().getTrack_id(),
                diary.getDiaryPhoto(),
                diary.getDiaryDate(),
                diary.getDiaryFeeling(),
                diary.getDiaryLongitude(),
                diary.getDiaryLatitude(),
                diary.getDiaryTitle(),
                diary.getDiaryWeather(),
                diary.getDiaryVisitRate(),
                diary.getDiaryWriting()
        );
    }
}