package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.TicketTypeDTO.TicketTypeCreateRequest;
import com.mxo.DTO.TicketTypeDTO.TicketTypeInfo;

public interface TicketTypeService {

    public ResponseEntity<?> createTicketType(TicketTypeCreateRequest ticketTypeCreateRequest);
    public List<TicketTypeInfo> getTicketTypes();
}
