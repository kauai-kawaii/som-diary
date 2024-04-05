package com.example.somdiary.repository;

import com.example.somdiary.entity.Diary;

import com.example.somdiary.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByUserId(User userId);
}
