package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.AuditoriumDTO.AuditoriumCreateRequest;
import com.mxo.DTO.AuditoriumDTO.AuditoriumInfo;

public interface AuditoriumService {
    
    public ResponseEntity<String> createAuditorium(AuditoriumCreateRequest request);
    public List<AuditoriumInfo> getAuditoriums();
}
