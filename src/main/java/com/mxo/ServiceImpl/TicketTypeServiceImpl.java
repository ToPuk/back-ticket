package com.mxo.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mxo.DTO.TicketTypeDTO.TicketTypeCreateRequest;
import com.mxo.DTO.TicketTypeDTO.TicketTypeInfo;
import com.mxo.DTOMapper.TicketTypeDTOMapper;
import com.mxo.Entity.TicketType;
import com.mxo.Repository.TicketTypeRepository;
import com.mxo.Service.TicketTypeService;
import com.mxo.Validator.ObjectValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final TicketTypeRepository ticketTypeRepository;
    private final ObjectValidator<TicketTypeCreateRequest> objectValidator;

    @Override
    public ResponseEntity<?> createTicketType(TicketTypeCreateRequest ticketTypeCreateRequest) {
        objectValidator.validate(ticketTypeCreateRequest);
        TicketType ticketType = TicketTypeDTOMapper.INSTANCE.createToEntity(ticketTypeCreateRequest);
        ticketTypeRepository.save(ticketType);
        return ResponseEntity.ok().body("Creation success");
    }

    @Override
    public List<TicketTypeInfo> getTicketTypes() {
        return ticketTypeRepository
            .findAll()
            .stream()
            .map(TicketTypeDTOMapper.INSTANCE::entityToResponse)
            .collect(Collectors.toList());
    }    
}
