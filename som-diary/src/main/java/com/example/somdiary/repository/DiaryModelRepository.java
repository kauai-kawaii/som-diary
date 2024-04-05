package com.example.somdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.somdiary.Models.DiaryModel;
import com.example.somdiary.Models.TrackModel;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface DiaryModelRepository extends JpaRepository<DiaryModel, Integer> {

    List<DiaryModel> findByDiaryDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT d.trackIdFk FROM DiaryModel d WHERE YEAR(d.diaryDate) = :year AND MONTH(d.diaryDate) = :month")
    List<DiaryModel> findDiaryByYearAndMonth(int year, int month);
}
