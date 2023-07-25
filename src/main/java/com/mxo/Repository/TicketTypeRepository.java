package com.mxo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mxo.Entity.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long>{
    
}
