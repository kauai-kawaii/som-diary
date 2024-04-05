package com.example.somdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.somdiary.repository.DiaryRepository;

@Service
public interface GetSongsFromDiary {
    
    public List<String> fromMonthAndYear(String month, String year);
}
 