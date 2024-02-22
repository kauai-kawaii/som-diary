package com.example.somdiary.repository;

import com.example.somdiary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
