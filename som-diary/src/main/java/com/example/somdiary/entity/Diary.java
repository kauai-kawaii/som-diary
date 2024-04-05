package com.example.somdiary.entity;

import java.time.LocalDate;

import com.example.somdiary.dto.DiaryDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "diary_id")
    private Long diaryId;

    // 회원 -> 다이어리 1:N
    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private User user;

    // 회원 - 음악 1:1
    // @OneToOne
    // @JoinColumn(name = "track_id_fk", referencedColumnName = "track_id")
    // private Track track;

    @Column(name = "diary_photo")
    private String diaryPhoto;

    // 날짜
    @Column(name = "diary_date")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDate diaryDate;

    // 기분
    @Column(name = "diary_feeling")
    private String diaryFeeling;

    // 위,경도
    @Column(name = "diary_latitude")
    private String diaryLatitude;

    @Column(name = "diary_longitude")
    private String diaryLongitude;

    @Column(name = "diary_visit_rate")
    private String diaryVisitRate;

    @Column(name = "diary_title", nullable = false)
    private String diaryTitle;

    @Column(name = "diary_writing", nullable = false)
    private String diaryWriting;

    @Column(name = "diary_weather")
    private String diaryWeather;

    public static Diary createDiary(DiaryDto dto, User user) {
        if (dto.getDiaryId() != null)
            throw new IllegalArgumentException("다이어리 생성 실패, 다이어리 id가 없어야 합니다.");

        System.out.println("DiaryDto의 사용자 ID: " + dto.getUserId());

        if (dto.getUserId() == null || !dto.getUserId().equals(user.getId()))
            throw new IllegalArgumentException("다이어리 생성 실패, 사용자의 id가 잘못됐습니다.");
        // 엔티티 생성 및 반환
        return new Diary(
                dto.getDiaryId(),
                user,
                // track,
                dto.getDiaryPhoto(),
                dto.getDiaryDate(),
                dto.getDiaryFeeling(),
                dto.getDiaryLatitude(),
                dto.getDiaryLongitude(),
                dto.getDiaryVisitRate(),
                dto.getDiaryTitle(),
                dto.getDiaryWriting(),
                dto.getDiaryWeather());
    }

    public void patch(DiaryDto dto) {
        if (this.diaryId != dto.getDiaryId())
            throw new IllegalArgumentException("다이어리 수정 실패! 잘못된 id가 입력되었습니다.");
        // 객체 갱신
        if (dto.getDiaryPhoto() != null)
            this.diaryPhoto = dto.getDiaryPhoto();
        if (dto.getDiaryDate() != null)
            this.diaryDate = dto.getDiaryDate();
        if (dto.getDiaryFeeling() != null)
            this.diaryFeeling = dto.getDiaryFeeling();
        if (dto.getDiaryLatitude() != null)
            this.diaryLatitude = dto.getDiaryLatitude();
        if (dto.getDiaryLongitude() != null)
            this.diaryLongitude = dto.getDiaryLongitude();
        if (dto.getDiaryVisitRate() != null)
            this.diaryVisitRate = dto.getDiaryVisitRate();
        if (dto.getDiaryTitle() != null)
            this.diaryTitle = dto.getDiaryTitle();
        if (dto.getDiaryWriting() != null)
            this.diaryWriting = dto.getDiaryWriting();
        if (dto.getDiaryWeather() != null)
            this.diaryWeather = dto.getDiaryWeather();
    }

}
