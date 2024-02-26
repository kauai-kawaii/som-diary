package com.example.somdiary.controllers;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("/api/user/{userId}/diary")
    public ResponseEntity<DiaryDto> create(@PathVariable String userId, @RequestBody DiaryDto dto){
        DiaryDto createdDto = diaryService.create(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}