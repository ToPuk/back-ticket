package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.ScreeningDTO.ScreeningCreateRequest;
import com.mxo.DTO.ScreeningDTO.ScreeningInfo;
import com.mxo.DTOMapper.ScreeningDTOMapper;
import com.mxo.Entity.Screening;
import com.mxo.Exception.ResourceNotFoundException;
import com.mxo.Repository.AuditoriumRepository;
import com.mxo.Repository.PerformanceRepository;
import com.mxo.Repository.ScreeningRepository;
import com.mxo.Service.ScreeningService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScreeningSeviceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final ObjectValidator<ScreeningCreateRequest> objectValidator;
    private final PerformanceRepository performanceRepository;
    private final AuditoriumRepository auditoriumRepository;

    @Override
    public ResponseEntity<?> createScreening(ScreeningCreateRequest screeningCreateRequest) {
        objectValidator.validate(screeningCreateRequest);
        if (!performanceRepository.existsById(screeningCreateRequest.getPerformanceId())){
            throw new ResourceNotFoundException(
                "Performance with id [%s] is not found"
                    .formatted(screeningCreateRequest.getPerformanceId())
            );
        }
        if (!auditoriumRepository.existsById(screeningCreateRequest.getAuditoriumId())) {
            throw new ResourceNotFoundException(
                "Auditorium with id [%s] is not found"
                    .formatted(screeningCreateRequest.getAuditoriumId())
            );
        }
        Screening screening = ScreeningDTOMapper.INSTANCE.createToEntity(screeningCreateRequest);
        screening.setAuditorium(
            auditoriumRepository
                .findById(screeningCreateRequest.getAuditoriumId())
                .get()
        );
        screening.setPerformance(
            performanceRepository
                .findById(screeningCreateRequest.getPerformanceId())
                .get()
        );
        screeningRepository.save(screening);
        return ResponseEntity.ok().body("Creation success");
    }

    @Override
    public List<ScreeningInfo> getScreenings() {
        return screeningRepository
            .findAll()
            .stream()
            .map(ScreeningDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }   
}
