package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.PerformanceFileDTO.PerformanceFileCreateRequest;
import com.mxo.DTO.PerformanceFileDTO.PerformanceFileInfo;
import com.mxo.DTOMapper.PerformanceFileDTOMapper;
import com.mxo.Entity.PerformanceFile;
import com.mxo.Exception.ResourceNotFoundException;
import com.mxo.Repository.PerformanceFileRepository;
import com.mxo.Repository.PerformanceRepository;
import com.mxo.Service.PerformanceFileService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceFileServiceImpl implements PerformanceFileService{

    private final PerformanceRepository performanceRepository;
    private final PerformanceFileRepository performanceFileRepository;
    private final ObjectValidator<PerformanceFileCreateRequest> objectValidator;
    @Override
    public ResponseEntity<?> createPerformanceFile(PerformanceFileCreateRequest performanceFileCreateRequest) {
        objectValidator.validate(performanceFileCreateRequest);
        if (!performanceRepository.existsById(performanceFileCreateRequest.getPerformanceId())){
            throw new ResourceNotFoundException(
                "Performance with id [%s] not found"
                    .formatted(
                        performanceFileCreateRequest.getPerformanceId()
                    )
            );
        }
        PerformanceFile performanceFile = PerformanceFileDTOMapper.INSTANCE.createToEntity(performanceFileCreateRequest);
        performanceFile.setPerformance(
            performanceRepository
                .findById(
                    performanceFileCreateRequest.getPerformanceId()
                )
                .get()
        );
        performanceFileRepository.save(performanceFile);
        return ResponseEntity.ok().body("Creation success");
    }
    @Override
    public List<PerformanceFileInfo> getPerformanceFiles() {
        return performanceFileRepository
            .findAll()
            .stream()
            .map(PerformanceFileDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }  
}
