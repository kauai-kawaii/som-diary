package com.example.somdiary.controllers;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DiaryController {
    @Autowired
    private DiaryService diaryService;
    // 다이어리 생성
    @PostMapping("/api/user/{userId}/diary")
    public ResponseEntity<DiaryDto> create(@PathVariable String userId, @RequestBody DiaryDto dto){
        // 서비스에 위임
        DiaryDto createdDto = diaryService.create(userId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}