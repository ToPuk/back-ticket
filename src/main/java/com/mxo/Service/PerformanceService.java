package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.PerformanceDTO.PerformanceCreateRequest;
import com.mxo.DTO.PerformanceDTO.PerformanceInfo;
import com.mxo.DTO.PerformanceDTO.PerformanceUpdateRequest;

public interface PerformanceService {
    
    public ResponseEntity<String> createPerformance(PerformanceCreateRequest request);
    public List<PerformanceInfo> getPerformances();
    public ResponseEntity<String> deletePerformance(Long performanceId);
    public ResponseEntity<String> updatePerformance(PerformanceUpdateRequest request);
}
