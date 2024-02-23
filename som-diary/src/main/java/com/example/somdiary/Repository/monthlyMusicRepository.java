package com.example.somdiary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.somdiary.Models.DiaryModel;

import jakarta.persistence.Converter;

import java.util.List;
import java.time.LocalDate;

public interface monthlyMusicRepository extends JpaRepository<DiaryModel, Integer> {

    static List<DiaryModel> findByDiaryDateBetweenDiaryDate(LocalDate start, LocalDate end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDiaryDateBetweenDiaryDate'");
    }
}
