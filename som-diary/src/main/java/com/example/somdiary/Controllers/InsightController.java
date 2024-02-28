package com.example.somdiary.Controllers;

// import org.hibernate.mapping.List;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import com.example.somdiary.Repository.monthlyMusicRepository;

import java.time.LocalDate;
import com.example.somdiary.Models.DiaryModel;
// import com.example.somdiary.Models.UserModel;
// import com.example.somdiary.Models.TrackModel;

import java.util.ArrayList;
import java.util.List; // Import the correct List class

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
    public @ResponseBody List<String> monthYearPick(@RequestParam(name = "selectedMonth") String month,
            @RequestParam(name = "selectedYear") String year) {

        // Getting the first day of the month for the diary within such month and year
        LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        // Getting the last day of the month for the diary within such month and year
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        List<DiaryModel> listOfDiary = monthlyMusicRepository
                .findByDiaryDateBetweenDiaryDate(firstDayOfMonth,
                        lastDayOfMonth);
        ArrayList<String> listOfSongs = new ArrayList<String>();
        // parse trackID for Spotify getTrack API
        for (DiaryModel diary : listOfDiary) {
            listOfSongs.add(diary.getTrackIdFk().toString());
        }

        return listOfSongs;
    }

}
