package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.PerformanceDTO.PerformanceCreateRequest;
import com.mxo.DTO.PerformanceDTO.PerformanceInfo;
import com.mxo.DTO.PerformanceDTO.PerformanceUpdateRequest;
import com.mxo.Service.PerformanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping
    public ResponseEntity<String> createPerformance(@RequestBody PerformanceCreateRequest request) {
        return performanceService.createPerformance(request);
    }

    @GetMapping
    public List<PerformanceInfo> getPerformances() {
        return performanceService.getPerformances();
    }

    @DeleteMapping(value = "{performanceId}")
    public ResponseEntity<String> deletePerformance(@PathVariable(name = "performanceId") Long performanceId) {
        return performanceService.deletePerformance(performanceId);
    }

    @PutMapping
    public ResponseEntity<String> updatePerformance(@RequestBody PerformanceUpdateRequest request) {
        return performanceService.updatePerformance(request);
    }
}
