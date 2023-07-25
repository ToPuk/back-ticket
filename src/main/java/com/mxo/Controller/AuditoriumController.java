package com.mxo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mxo.DTO.AuditoriumDTO.AuditoriumCreateRequest;
import com.mxo.DTO.AuditoriumDTO.AuditoriumInfo;
import com.mxo.Service.AuditoriumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auditorium")
public class AuditoriumController {
 
    private final AuditoriumService auditoriumService;

    @PostMapping
    public ResponseEntity<String> createAuditorium(@RequestBody AuditoriumCreateRequest request) {
        return auditoriumService.createAuditorium(request);
    }

    @GetMapping
    public List<AuditoriumInfo> getAuditoriums() {
        return auditoriumService.getAuditoriums();
    }
}
