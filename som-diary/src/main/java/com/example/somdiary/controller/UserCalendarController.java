package com.example.somdiary.controller;

import com.example.somdiary.dto.MainPhotoDto;
import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserCalendarController{

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    public UserCalendarController(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/api/photos")
    public List<MainPhotoDto> getDiaries() {


        User user = userRepository.findById("123").orElse(null);
        System.out.println("User ID: " + user.getId());
        System.out.println("Username: " + user.getUserName());
//        System.out.println("Email: " + user.getUserEmail());


        List<Diary> diaries = diaryRepository.findByUser(user);
        List<MainPhotoDto> mainPhotoDtos = new ArrayList<>();

        for (Diary diary : diaries) {
            System.out.println("다이어리 id: " + diary.getDiaryId());
            System.out.println("유저객체의 유저아이디: " + diary.getUser().getId());
            System.out.println("getDiaryPhoto(): " + diary.getDiaryPhoto());
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
        System.out.println("mainPhotoDtos" + mainPhotoDtos.toString());

        return mainPhotoDtos;
    }
}
