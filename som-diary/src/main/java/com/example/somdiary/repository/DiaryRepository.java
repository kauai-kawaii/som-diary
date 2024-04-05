package com.example.somdiary.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.somdiary.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    // UserId for test: 108921399018309814574
    List<Diary> findByUserId(String userId);

}
