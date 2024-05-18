package com.bookmyshow.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Show {
    @Id
    @SequenceGenerator(
            name = "sequence_showId",
            sequenceName = "sequence_showId"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_showId"

    )
    private Long showId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdOn;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @OneToOne(
            cascade = CascadeType.ALL

    )
    @JoinColumn(
            name = "movie_id"

    )
    private Movie movie;

    @OneToOne(
            cascade = CascadeType.ALL

    )
    @JoinColumn(
            name = "cinema_id"
    )
    private Cinema cinema;
}
