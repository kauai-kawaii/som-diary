package com.example.somdiary.Controllers;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

import com.example.somdiary.Repository.monthlyMusicRepository;

import java.time.LocalDate;
import java.util.*;
import com.example.somdiary.Models.DiaryModel;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class InsightController {
    /*
     * get the songs playlist added in specific month and year
     * fetch the songs from the database, filtered by the month and year
     * those month and year are from react components named YearPicker and
     * MonthPicker
     * set the month variable named 'month' and year variable named 'year'
     */
    @GetMapping("/insight")
    public String monthYearPick(@RequestParam(name = "diaryMonth") String month,
            @RequestParam(name = "diaryYear") String year) {

        // Getting the first day of the month for the diary within such month and year
        LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        // Getting the end day of the month for the diary within such month and year
        LocalDate lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1);

        /*
         * Get the list of songs from the database "diary" table. Use repository
         * "monthlyMusicRepository" to fetch the data
         * The data is filtered by the month and year
         * The data is fetched from the database and stored in the list
         */

        // return the list of songs
        List<DiaryModel> songs = monthlyMusicRepository.findByDiaryDateBetweenDiaryDate(firstDayOfMonth,
                lastDayOfMonth);

        return "insight";
    }

}
