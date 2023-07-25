package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.SeatDTO.SeatCreateRequest;
import com.mxo.DTO.SeatDTO.SeatInfo;
import com.mxo.Service.SeatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/seats")
@RequiredArgsConstructor
public class SeatController {
    
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<String> createSeat(@RequestBody SeatCreateRequest request) {
        return seatService.createSeat(request);
    }

    @GetMapping
    public List<SeatInfo> getSeats() {
        return seatService.getSeats();
    }

    @GetMapping("{auditoriumId}")
    public List<SeatInfo> getSeatsByAuditoriumId(@PathVariable(name = "auditoriumId") Long auditoriumId) {
        return seatService.getSeatsByAuditoriumId(auditoriumId);
    }
}
