package com.example.somdiary.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.repository.UserRepository;

@Slf4j
@Service
public class InsightService {

    @Autowired
    // To get diary and user data by repositories
    DiaryRepository diaryRepository;
    UserRepository userRepository;

    // Load all diaries by specific user
    public List<Diary> getDiaryByUserId(String userId) {

        User user = userRepository.findById(userId).orElse(null);

        // When the exception is thrown
        if (user == null) {
            log.error("User not found");
            return null;
        }

        log.info("Getting diary by user id: {}", userId);
        return diaryRepository.findByUserId(user);
    }

}
