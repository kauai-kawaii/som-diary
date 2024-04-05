package com.example.somdiary.repository;


import com.example.somdiary.entity.Diary;
import com.example.somdiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;  

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByUserIdAndDiaryDate(String userId, LocalDate diaryDate);
    // UserId for test: 108921399018309814574
    List<Diary> findByUserId(User userId);

}
