package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.PerformanceFileDTO.PerformanceFileCreateRequest;
import com.mxo.DTO.PerformanceFileDTO.PerformanceFileInfo;
import com.mxo.Service.PerformanceFileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/performanceFiles")
public class PerformanceFileController {

    private final PerformanceFileService performanceFileService;

    @PostMapping
    public ResponseEntity<?> createPerformanceFile(@RequestBody PerformanceFileCreateRequest performanceFileCreateRequest) {
        return performanceFileService.createPerformanceFile(performanceFileCreateRequest);
    }

    @GetMapping
    public List<PerformanceFileInfo> getPerformanceFiles(){
        return performanceFileService.getPerformanceFiles();
    }
}
