package com.mxo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MXO_AUDITORIUM")
public class Auditorium {
 
    @Id
    @SequenceGenerator(
        name = "auditorium_id_sequence", 
        sequenceName = "auditorium_id_sequence", 
        allocationSize = 1, 
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "auditorium_id_sequence"
    )
    @Column(name = "AUDITORIUM_ID", nullable = false)
    private Long auditoriumId;

    @Column(name = "AUDITORIUM_NAME", nullable = false, length = 50)
    private String auditoriumName;

    @Column(name = "TOTAL_SEATS", nullable = false)
    private Integer totalSeats;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @OneToMany(mappedBy = "auditorium")
    private List<Screening> screenings;
}
