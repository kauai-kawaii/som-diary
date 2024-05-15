package com.example.somdiary.controller;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.User;
import com.example.somdiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.hibernate.mapping.List;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.service.InsightService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import java.time.LocalDate;

import com.example.somdiary.entity.Diary;
// import com.example.somdiary.Models.UserModel;
// import com.example.somdiary.Models.TrackModel;

import java.util.ArrayList;
import java.util.List; // Import the correct List class

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/insight")
// @RequestMapping("/api")
public class InsightController {

    @Autowired
    private InsightService insightService;

    @GetMapping("/{userId}")
//    public String getDiariesByUserId(@PathVariable String userId) {
    public ResponseEntity<List<Diary>> getDiariesByUserId(@PathVariable String userId) {


        List<Diary> diaries = insightService.getDiaryByUserId(userId);
        if (diaries.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diaries);


//
    }

}
