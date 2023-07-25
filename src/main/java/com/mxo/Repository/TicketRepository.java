package com.mxo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mxo.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
}
