package com.example.somdiary.controllers;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.UserRepository;
import com.example.somdiary.service.DiaryService;
import com.wrapper.spotify.exceptions.detailed.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @GetMapping("/user/{userId}/{dairy_date}")
    public ResponseEntity<DiaryDto> getDiariesByUserIdAndDate(@PathVariable String userId, @PathVariable String dairy_date) {
        LocalDate parsedDate = LocalDate.parse(dairy_date);
        DiaryDto diary = diaryService.getDiaryByUserIdAndDiaryDate(userId, parsedDate);
        return ResponseEntity.ok(diary);
    }

    @PostMapping("/api/user/{userId}/diary")
    public ResponseEntity<DiaryDto> create(@PathVariable String userId, @RequestBody DiaryDto dto){
        DiaryDto createdDto = diaryService.create(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}