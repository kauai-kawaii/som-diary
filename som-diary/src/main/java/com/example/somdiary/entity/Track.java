package com.example.somdiary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Data
public class Track {
    @Id
    @Column(name = "track_id")
    private Long trackId;

    @Column(name = "track_title")
    private String trackTitle;

}

