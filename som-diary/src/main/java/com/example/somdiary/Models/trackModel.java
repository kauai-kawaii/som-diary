package com.example.somdiary.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class trackModel {
    @Id
    String track_id;
    String track_name;
    String track_artist;
    String track_image;
}
