package com.example.somdiary.entity;

import com.example.somdiary.dto.DiaryDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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
    private User user;

    // 회원 - 음악 1:1
//    @OneToOne
//    @JoinColumn(name = "track_id_fk", referencedColumnName = "track_id")
//    private Track track;

    @Column(name = "diary_photo")
    private String diaryPhoto;

    // 날짜
    @Column(name = "diary_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaryDate;

    // 기분
    @Column(name = "diary_feeling")
    private String diaryFeeling;

    // 위,경도
    @Column(name = "diary_latitude")
    private String diaryLatitude;

    @Column(name="diary_longitude")
    private String diaryLongitude;

    @Column(name="diary_visit_rate")
    private String diaryVisitRate;

    @Column(name = "diary_title", length = 100, nullable = false)
    private String diaryTitle;

    @Column(name = "diary_writing", columnDefinition = "TEXT", nullable = false)
    private String diaryWriting;

    @Column(name = "diary_weather")
    private String diaryWeather;

    public static Diary createDiary(DiaryDto dto, User user) {
        if(dto.getDiaryId() != null)
            throw new IllegalArgumentException("다이어리 생성 실패, 다이어리 id가 없어야 한다.");

        System.out.println("DiaryDto의 사용자 ID: " + dto.getUserId());

        if (dto.getUserId() == null || !dto.getUserId().equals(user.getId()))
            throw new IllegalArgumentException("다이어리 생성 실패, 사용자의 id가 잘못됐습니다.");
        //엔티티 생성 및 반환
        return new Diary(
                dto.getDiaryId(),
                user,
//                track,
                dto.getDiaryPhoto(),
                dto.getDiaryDate(),
                dto.getDiaryFeeling(),
                dto.getDiaryLatitude(),
                dto.getDiaryLongitude(),
                dto.getDiaryTitle(),
                dto.getDiaryWeather(),
                dto.getDiaryVisitRate(),
                dto.getDiaryWriting()
        );
    }
}
