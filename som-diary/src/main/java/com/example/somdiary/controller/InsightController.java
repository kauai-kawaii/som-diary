package com.example.somdiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.hibernate.mapping.List;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import com.example.somdiary.repository.DiaryRepository;
import com.example.somdiary.service.GetSongsFromDiary;

import java.time.LocalDate;
import com.example.somdiary.entity.Diary;
// import com.example.somdiary.Models.UserModel;
// import com.example.somdiary.Models.TrackModel;

import java.util.ArrayList;
import java.util.List; // Import the correct List class
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/insight")
// @RequestMapping("/api")
public class InsightController {
    /*
     * get the songs playlist added in specific month and year
     * fetch the songs from the database, filtered by the month and year
     * those month and year are from react components named YearPicker and
     * MonthPicker
     * set the month variable named 'month' and year variable named 'year'
     */

    // @GetMapping("/tracks")
    // public @ResponseBody String monthYearPick(@RequestParam(name =
    // "selectedMonth") String selectedMonth,
    // @RequestParam(name = "selectedYear") String selectedYear) {

    // return
    // }

    // @GetMapping("/tracks/{userId}")
    // public @ResponseBody String tracksOfSpecificUser(@RequestParam(name =
    // "selectedMonth") String selectedMonth,
    // @RequestParam(name = "selectedYear") String selectedYear) {

    // // Getting the first day of the month for the diary within such month and
    // year
    // // By using @Service getSongsFromDiaryImpl

    // DiaryRepository diaryRepository = new DiaryRepository();

    // List <Diary> diaryList = new ArrayList<Diary>();
    // diaryList = getSongsFromDiary.fromMonthAndYear(selectedMonth, selectedYear);
    // // return getSongsFromDiary.fromMonthAndYear(month, year);
    // return selectedYear + "-" + selectedMonth;
    // }

}
