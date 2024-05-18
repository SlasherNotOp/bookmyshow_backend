package com.bookmyshow.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CinemaHall {
    @Id
    @SequenceGenerator(
            name = "sequence_cinemaHallId",
            sequenceName = "sequence_cinemaHallId"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_cinemaHallId"
    )
    private Long cinemaHallId;
    private String CinemaHallName;
    private int totalSeats;
}
