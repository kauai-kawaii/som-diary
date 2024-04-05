package com.example.somdiary.controller;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.service.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @GetMapping("/user/{userId}/{diary_date}")
    public ResponseEntity<DiaryDto> getDiariesByUserIdAndDate(@PathVariable String userId, @PathVariable String diary_date) {
        LocalDate parsedDate = LocalDate.parse(diary_date);
        DiaryDto diary = diaryService.getDiaryByUserIdAndDiaryDate(userId, parsedDate);
        return ResponseEntity.ok(diary);
    }


    // 다이어리 업데이트
    @PutMapping("/user/{userId}/{diary_date}")
    public ResponseEntity<DiaryDto> updateDiaryByUserIdAndDate(@PathVariable String userId, @PathVariable String diary_date, @RequestBody DiaryDto dto) {
        LocalDate parsedDate = LocalDate.parse(diary_date);
        DiaryDto updated = diaryService.updateDiaryByUserIdAndDiaryDate(userId, parsedDate, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/user/{userId}/diary")
    public ResponseEntity<DiaryDto> create(@PathVariable String userId, @RequestBody DiaryDto dto){
        DiaryDto createdDto = diaryService.create(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 다이어리 삭제
    @DeleteMapping("/api/diary/{diaryId}")
    public ResponseEntity<DiaryDto> deleteDiary(@PathVariable Long diaryId){
        Diary deleted = diaryService.delete(diaryId); // 게시글 삭제
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}