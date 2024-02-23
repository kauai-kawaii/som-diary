package com.example.somdiary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TrackModel {
    @Id
    @ManyToOne
    @Column(name = "track_id")
    String trackId;

    // Below 3 fields would be fetched from Spotify GetTrack API
    @Column(name = "track_title") // Fetch track name from Spotify API
    String trackTitle;

    // @Column(name = "track_artist") // Fetch artist name from Spotify API
    // String trackArtist;

    // @Column(name = "track_image") // Fetch img url from Spotify API
    // String trackImage;
}