package com.example.somdiary.service;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiaryService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DiaryRepository diaryRepository;

    @Transactional
    public DiaryDto create(String userId, DiaryDto dto) {
        // 유저 조회 및 예외 발생
        User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new IllegalArgumentException("유저가 없음."));
        // 다이어리 엔티티 생성
        Diary diary = Diary.createDiary(dto, user);
        // 다이어리 엔티티를 DB에 저장
        Diary created = diaryRepository.save(diary);
        // DTO로 변환 반환
        return DiaryDto.createdDiaryDto(created);
    }
}