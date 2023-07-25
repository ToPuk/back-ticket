package com.mxo.Entity;

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
@Table(name = "MXO_TICKET")
public class Ticket {

    @Id
    @SequenceGenerator(
        name = "ticket_id_sequence",
        sequenceName = "ticket_id_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ticket_id_sequence"
    )
    private Long ticketId;

    @ManyToOne
    @JoinColumn(
        name = "TICKET_TYPE_ID",
        foreignKey = @ForeignKey(name = "ticketType_id_fk"),
        nullable = false
    )
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(
        name = "SCREENING_ID",
        foreignKey = @ForeignKey(name = "screening_id_fk"),
        nullable = false
    )
    private Screening screening;

    @ManyToOne
    @JoinColumn(
        name = "SEAT_ID",
        foreignKey = @ForeignKey(name = "seat_id_fk"),
        nullable = false
    )
    private Seat seat;
}
