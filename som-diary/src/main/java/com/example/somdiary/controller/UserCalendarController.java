package com.example.somdiary.controller;

import com.example.somdiary.dto.CustomOAuth2User;
import com.example.somdiary.dto.MainPhotoDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserCalendarController{

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    public UserCalendarController(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/photos")
    @ResponseBody
    public List<MainPhotoDto> getPhotos(Authentication authentication) {
        // 현재 로그인한 사용자의 정보 가져오기
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String userId = customOAuth2User.getId();

        // 사용자 ID를 이용하여 해당 사용자의 정보 조회
        User user = userRepository.findById(userId).orElse(null);
        List<Diary> diaries = diaryRepository.findByUser(user);
        List<MainPhotoDto> mainPhotoDtos = new ArrayList<>();

        for (Diary diary : diaries) {
            MainPhotoDto mainPhotoDto = new MainPhotoDto();
            mainPhotoDto.setDiaryId(diary.getDiaryId());
            mainPhotoDto.setUserId(diary.getUser().getId());
            mainPhotoDto.setDiaryPhoto(diary.getDiaryPhoto());

            // LocalDate에서 연월일 분리
            mainPhotoDto.setYear(diary.getDiaryDate().getYear());
            mainPhotoDto.setMonth(diary.getDiaryDate().getMonthValue());
            mainPhotoDto.setDate(diary.getDiaryDate().getDayOfMonth());

            mainPhotoDtos.add(mainPhotoDto);
        }

        return mainPhotoDtos;
    }
}