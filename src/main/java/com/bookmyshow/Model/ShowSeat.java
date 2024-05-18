package com.bookmyshow.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ShowSeat {
    @Id
    @SequenceGenerator(
            name = "Show_seat_sequence_generator",
            sequenceName = "Show_seat_sequence_generator"
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "Show_seat_sequence_generator"
    )
    private Long ShowSeatId;
    private int seatNo;
    private Boolean isReserved;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "show_Id",
            referencedColumnName = "showId"
    )
    private Show show;
}
