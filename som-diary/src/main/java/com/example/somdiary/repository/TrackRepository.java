package com.example.somdiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.somdiary.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByTrackId(Long trackId); // Get individual track by trackId

    // Get all the Tracks contained in DB
    List<Track> findAll();

}
