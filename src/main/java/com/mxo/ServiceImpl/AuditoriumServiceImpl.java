package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.AuditoriumDTO.AuditoriumCreateRequest;
import com.mxo.DTO.AuditoriumDTO.AuditoriumInfo;
import com.mxo.DTOMapper.AuditoriumDTOMapper;
import com.mxo.Entity.Auditorium;
import com.mxo.Repository.AuditoriumRepository;
import com.mxo.Service.AuditoriumService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;
    private final ObjectValidator<AuditoriumCreateRequest> objectValidator;

    @Override
    public ResponseEntity<String> createAuditorium(AuditoriumCreateRequest request) {
        objectValidator.validate(request);
        Auditorium auditorium = AuditoriumDTOMapper.INSTANCE.createToEntity(request);
        auditoriumRepository.save(auditorium);
        return ResponseEntity.ok().body("Creation success");
    }

    @Override
    public List<AuditoriumInfo> getAuditoriums() {
        return auditoriumRepository
            .findAll()
            .stream()
            .map(AuditoriumDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }
}
