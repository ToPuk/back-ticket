package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.SeatDTO.SeatCreateRequest;
import com.mxo.DTO.SeatDTO.SeatInfo;

public interface SeatService {
    
    public ResponseEntity<String> createSeat(SeatCreateRequest request);
    public List<SeatInfo> getSeats();
    public List<SeatInfo> getSeatsByAuditoriumId(Long auditoriumId);
}
