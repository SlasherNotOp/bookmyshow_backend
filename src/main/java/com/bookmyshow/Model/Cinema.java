package com.bookmyshow.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    @Id
    @SequenceGenerator(
            name = "cinema_sequence_generator",
            sequenceName = "cinema_sequence_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cinema_sequence_generator"

    )
    private Long cinemaId;

    private String name;
    private int cinemaHalls;
    private String address;



}
