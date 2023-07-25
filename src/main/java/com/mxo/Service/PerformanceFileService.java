package com.mxo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mxo.DTO.PerformanceFileDTO.PerformanceFileCreateRequest;
import com.mxo.DTO.PerformanceFileDTO.PerformanceFileInfo;

public interface PerformanceFileService {
    
    public ResponseEntity<?> createPerformanceFile(PerformanceFileCreateRequest performanceFileCreateRequest);
    public List<PerformanceFileInfo> getPerformanceFiles();
}
