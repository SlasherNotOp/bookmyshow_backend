package com.bookmyshow.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long movieId;
    private String timovieIdtle;

    @Column(length = 400)
    private String description;

    private int durationInMins;
    private String language;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private String country;

    private String genre;




}
