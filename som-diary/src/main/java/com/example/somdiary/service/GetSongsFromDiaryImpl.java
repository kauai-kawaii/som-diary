package com.example.somdiary.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.somdiary.repository.DiaryRepository;

@Service
public class GetSongsFromDiaryImpl implements GetSongsFromDiary {

    @Autowired
    private DiaryRepository diaryModelRepository;

    @Override
    public List<String> fromMonthAndYear(String month, String year) {

        // Getting the first day of the month for the diary within such month and year
        LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        // Getting the last day of the month for the diary within such month and year
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        // // Fetch the songs from the database, filtered by the month and year
        // List<DiaryModel> listOfDiary =
        // diaryModelRepository.findByDiaryDateBetween(firstDayOfMonth,
        // lastDayOfMonth);

        // // For Return the list of songs TrackID in Spotify
        // List<String> listOfSongs = new ArrayList<String>();
        // // parse trackID for Spotify getTrack API
        // for (DiaryModel diary : listOfDiary) {
        // listOfSongs.add(diary.getTrackIdFk().toString());
        // }
        List<String> listOfSongs = new ArrayList<String>();
        listOfSongs.add("Empty");
        return listOfSongs;
    }

}
