package com.bookmyshow.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence_generator",
            sequenceName = "booking_sequence_generator"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "booking_sequence_generator"
    )
    private Long BookingId;
    private String BookingdNumber;
    private LocalDate CreatedOn;
    private Boolean status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "show_id",
            referencedColumnName = "showId"
    )
    private Show show;
}
