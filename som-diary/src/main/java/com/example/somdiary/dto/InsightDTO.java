package com.example.somdiary.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class InsightDTO {
    // From Diary
    private String userId;
    private LocalDate diaryDate;
    // From Track
    private String trackId;

    public static InsightDTO createInsightDTO(String userId, LocalDate diaryDate, String trackId) {
        return new InsightDTO(userId, diaryDate, trackId);
    }

}
