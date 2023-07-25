package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.ScreeningDTO.ScreeningCreateRequest;
import com.mxo.DTO.ScreeningDTO.ScreeningInfo;
import com.mxo.Service.ScreeningService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    @PostMapping
    public ResponseEntity<?> createScreening(@RequestBody ScreeningCreateRequest screeningCreateRequest) {
        return screeningService.createScreening(screeningCreateRequest);
    }
    
    @GetMapping
    public List<ScreeningInfo> getScreenings() {
        return screeningService.getScreenings();
    }
}
