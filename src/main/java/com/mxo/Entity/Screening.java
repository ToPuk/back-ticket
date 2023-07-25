package com.mxo.Entity;

import java.time.LocalDateTime;

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
@Table(name = "MXO_SCREENING")
public class Screening {
    
    @Id
    @SequenceGenerator(
        name = "screening_id_sequence",
        sequenceName = "screening_id_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "screening_id_sequence"
    )
    @Column(name = "SCREENING_ID", nullable = false)
    private Long screeningId;

    @Column(name = "START_DATE_TIME", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "END_DATE_TIME", nullable = false)
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(
        name = "PERFORMANCE_ID",
        foreignKey = @ForeignKey(name = "performance_id_fk"),
        nullable = false
    )
    private Performance performance;

    @ManyToOne
    @JoinColumn(
        name = "AUDITORIUM_ID",
        foreignKey = @ForeignKey(name = "auditorium_id_fk"),
        nullable = false
    )
    private Auditorium auditorium;
}
