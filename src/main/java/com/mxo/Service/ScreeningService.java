package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.ScreeningDTO.ScreeningCreateRequest;
import com.mxo.DTO.ScreeningDTO.ScreeningInfo;

public interface ScreeningService {
    
    public ResponseEntity<?> createScreening (ScreeningCreateRequest screeningCreateRequest);
    public List<ScreeningInfo> getScreenings ();
}
