package com.example.somdiary.service;

import com.example.somdiary.dto.DiaryDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiaryService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DiaryRepository diaryRepository;

    public DiaryDto getDiaryByUserIdAndDiaryDate(String userId, LocalDate date) {
        List<Diary> diaries = diaryRepository.findByUserIdAndDiaryDate(userId, date);
        if (diaries.isEmpty()) {
            return null;
//            throw new IllegalArgumentException("해당 사용자와 날짜에 대한 다이어리를 찾을 수 없습니다.");
        }
        Diary diary = diaries.get(0);
        return DiaryDto.createdDiaryDto(diary);
    }


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

    @Transactional
    public DiaryDto updateDiaryByUserIdAndDiaryDate(String userId, LocalDate parsedDate, DiaryDto dto) {
        // 타깃 조회하기
        List<Diary> diaries = diaryRepository.findByUserIdAndDiaryDate(userId, parsedDate);
        if (diaries.isEmpty()) {
            throw new IllegalArgumentException("해당 사용자와 날짜에 대한 다이어리를 찾을 수 없습니다.");
        }
        // 업데이트
        Diary target = diaries.get(0);
        target.patch(dto);
        Diary updated = diaryRepository.save(target);
        return DiaryDto.createdDiaryDto(updated);
    }

    public Diary delete(Long diaryId) {
        // 대상 찾기
        Diary target = diaryRepository.findById(diaryId).orElse(null);
        // 잘못된 요청 처리하기
        if (target == null){
            return null;
        }
        // 대상 삭제하기
        diaryRepository.delete(target);
        return target; // DB에서 삭제한 대상을 컨트롤러에 반환
    }
}