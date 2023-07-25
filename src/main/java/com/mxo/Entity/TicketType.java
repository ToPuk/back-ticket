package com.mxo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MXO_TICKET_TYPE")
public class TicketType {
    
    @Id
    @SequenceGenerator(
        name = "ticketType_id_sequence",
        sequenceName = "ticketType_id_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ticketType_id_sequence"
    )
    @Column(name = "TICKET_TYPE_ID", nullable = false)
    private Long ticketTypeId;

    @Column(name = "TICKET_TYPE_NAME", nullable = false)
    private String ticketTypeName;

    @Column(name = "TICKET_PRICE", nullable = false)
    private Integer ticketPrice;
}
