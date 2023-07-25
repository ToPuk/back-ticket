package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.PerformanceDTO.PerformanceCreateRequest;
import com.mxo.DTO.PerformanceDTO.PerformanceInfo;
import com.mxo.DTO.PerformanceDTO.PerformanceUpdateRequest;
import com.mxo.DTOMapper.PerformanceDTOMapper;
import com.mxo.Entity.Performance;
import com.mxo.Exception.ResourceNotFoundException;
import com.mxo.Repository.PerformanceRepository;
import com.mxo.Service.PerformanceService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final ObjectValidator<PerformanceCreateRequest> objectValidator;
    
    @Override
    public ResponseEntity<String> createPerformance(PerformanceCreateRequest request) {
        objectValidator.validate(request);
        Performance performance = PerformanceDTOMapper.INSTANCE.createToEntity(request);
        performanceRepository.save(performance);
        return ResponseEntity.ok().body("Creation success");
    }

    @Override
    public List<PerformanceInfo> getPerformances() {
        return performanceRepository
            .findAll()
            .stream()
            .map(PerformanceDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> deletePerformance(Long performanceId) {
        if (!performanceRepository.existsById(performanceId)) {
            throw new ResourceNotFoundException(
                "Performance with id [%s] not found"
                    .formatted(performanceId)
                );
        }
        performanceRepository.deleteById(performanceId);
        return ResponseEntity.ok().body("Deletion success");
    }

    @Override
    public ResponseEntity<String> updatePerformance(PerformanceUpdateRequest request) {
        if (!performanceRepository.existsById(request.getPerformanceId())) {
            throw new ResourceNotFoundException(
                "Performance with id [%s] not found"
                    .formatted(request.getPerformanceId())
            );
        }
        Performance performance = performanceRepository
            .findById(request.getPerformanceId())
            .get();
        PerformanceDTOMapper.INSTANCE.updateToEntity(request, performance);
        performanceRepository.save(performance);
        return ResponseEntity.ok().body("Update success");
    }
}
