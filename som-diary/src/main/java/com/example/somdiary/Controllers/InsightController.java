package com.example.somdiary.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return "insight";
    }

}
