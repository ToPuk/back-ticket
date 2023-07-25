package com.mxo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MXO_SEAT")
public class Seat {

    @Id
    @SequenceGenerator(
        name = "seat_id_sequence", 
        sequenceName = "seat_id_sequence", 
        allocationSize = 1, 
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "seat_id_sequence"
    )
    @Column(name = "SEAT_ID", nullable = false)
    private Long seatId;
    @Column(name = "SEAT_NUMBER")
    private Integer seatNumber;
    @Column(name = "ROW_NUMBER", nullable = false)
    private Integer rowNumber;
    @Column(name = "FLOOR_NUMBER", nullable = false)
    private Integer floorNumber;

    @ManyToOne
    @JoinColumn(
        name = "AUDITORIUM_ID",
        foreignKey = @ForeignKey(name = "auditorium_id_fk"),
        nullable = false
    )
    private Auditorium auditorium;
}
