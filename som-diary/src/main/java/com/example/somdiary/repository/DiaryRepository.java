package com.example.somdiary.repository;

import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByUserIdAndDiaryDate(String userId, LocalDate diaryDate);

    List<Diary> findByUser(User userId);

    // UserId for test: 123
    List<Diary> findByUserId(String userId);
}
