package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.SeatDTO.SeatCreateRequest;
import com.mxo.DTO.SeatDTO.SeatInfo;
import com.mxo.DTOMapper.SeatDTOMapper;
import com.mxo.Entity.Seat;
import com.mxo.Exception.ResourceNotFoundException;
import com.mxo.Repository.AuditoriumRepository;
import com.mxo.Repository.SeatRepository;
import com.mxo.Service.SeatService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    
    private final SeatRepository seatRepository;
    private final ObjectValidator<SeatCreateRequest> objectValidator;
    private final AuditoriumRepository auditoriumRepository;

    @Override
    public ResponseEntity<String> createSeat(SeatCreateRequest request) {
        objectValidator.validate(request);
        if (!auditoriumRepository.existsById(request.getAuditoriumId())){
            throw new ResourceNotFoundException(
                "Auditorium with id [%s] not found"
                    .formatted(request.getAuditoriumId())
            );
        }
        Seat seat = SeatDTOMapper.INSTANCE.createToEntity(request);
        seat.setAuditorium(
            auditoriumRepository
                .findById(request.getAuditoriumId())
                .get()
        );
        seatRepository.save(seat);
        return ResponseEntity.ok().body("Creation success");
    }

    @Override
    public List<SeatInfo> getSeats() {
        return seatRepository
            .findAll()
            .stream()
            .map(SeatDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public List<SeatInfo> getSeatsByAuditoriumId(Long auditoriumId) {
        return seatRepository
            .findByAuditoriumId(auditoriumId)
            .stream()
            .map(SeatDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }
}
