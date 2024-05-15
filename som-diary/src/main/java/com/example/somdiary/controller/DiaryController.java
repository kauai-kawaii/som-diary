package com.example.somdiary.controller;

import com.example.somdiary.dto.CustomOAuth2User;
import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.service.DiaryService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @GetMapping("/user/{diary_date}")
    public ResponseEntity<DiaryDto> getDiariesByUserIdAndDate(Authentication authentication, @PathVariable String diary_date) {

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getId();

        LocalDate parsedDate = LocalDate.parse(diary_date);
        DiaryDto diary = diaryService.getDiaryByUserIdAndDiaryDate(userId, parsedDate);
        return ResponseEntity.ok(diary);
    }


    @GetMapping("/edit/{diary_date}")
    public ResponseEntity<DiaryDto> getEditDiariesByUserIdAndDate(Authentication authentication, @PathVariable String diary_date) {

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getId();

        LocalDate parsedDate = LocalDate.parse(diary_date);
        DiaryDto diary = diaryService.getDiaryByUserIdAndDiaryDate(userId, parsedDate);
        return ResponseEntity.ok(diary);
    }

    // 다이어리 업데이트
    @PostMapping("/edit/{diary_date}")
    public ResponseEntity<DiaryDto> updateDiaryByUserIdAndDate(Authentication authentication, @PathVariable String diary_date, @RequestBody DiaryDto dto) {

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getId();

        LocalDate parsedDate = LocalDate.parse(diary_date);
        DiaryDto updated = diaryService.updateDiaryByUserIdAndDiaryDate(userId, parsedDate, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/new")
    public ResponseEntity<DiaryDto> create(Authentication authentication, @RequestBody DiaryDto dto){

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getId();

        DiaryDto createdDto = diaryService.create(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 다이어리 삭제
    @DeleteMapping("/diary/{diaryId}")
    public ResponseEntity<DiaryDto> deleteDiary(@PathVariable Long diaryId){
        Diary deleted = diaryService.delete(diaryId); // 게시글 삭제
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}