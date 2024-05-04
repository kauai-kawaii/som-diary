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

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Autowired
    public InsightService(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    public List<Diary> getDiaryByUserId(String userId) {

        // Get the user by userId
        User user = userRepository.findById("123").orElse(null);
        List<Diary> diariesOfUser = diaryRepository.findByUserId(user.getId());
        // Get the diaries by user
        return diariesOfUser;
    }

}
