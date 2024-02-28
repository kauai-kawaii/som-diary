package com.example.somdiary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "track")
public class TrackModel {
    @Id
    @Column(name = "track_id")
    String trackId;

    // Below 3 fields would be fetched from Spotify GetTrack API
    @Column(name = "track_title") // Fetch track name from Spotify API
    String trackTitle;

    @OneToMany(mappedBy = "trackIdFk")
    private List<DiaryModel> diary;

    // @Column(name = "track_artist") // Fetch artist name from Spotify API
    // String trackArtist;

    // @Column(name = "track_image") // Fetch img url from Spotify API
    // String trackImage;

    // Empty and Full Contructors
    public TrackModel() {
    }

    public TrackModel(String trackId, String trackTitle) {
        this.trackId = trackId;
        this.trackTitle = trackTitle;
    }
}