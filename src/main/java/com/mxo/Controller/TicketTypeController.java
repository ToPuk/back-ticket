package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.TicketTypeDTO.TicketTypeCreateRequest;
import com.mxo.DTO.TicketTypeDTO.TicketTypeInfo;
import com.mxo.Service.TicketTypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticketTypes")
public class TicketTypeController {
    
    private final TicketTypeService ticketTypeService;

    @PostMapping
    public ResponseEntity<?> createTicketType(@RequestBody TicketTypeCreateRequest ticketTypeCreateRequest) {
        return ticketTypeService.createTicketType(ticketTypeCreateRequest);
    }

    @GetMapping
    public List<TicketTypeInfo> getTicketTypes(){
        return ticketTypeService.getTicketTypes();
    }
}

