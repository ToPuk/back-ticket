package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.SeatDTO.SeatCreateRequest;
import com.mxo.DTO.SeatDTO.SeatInfo;
import com.mxo.Entity.Seat;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SeatDTOMapper {
    SeatDTOMapper INSTANCE = Mappers.getMapper(SeatDTOMapper.class);

    @Mapping(target = "auditoriumId", source = "auditorium.auditoriumId")
    SeatInfo entityToResponse(Seat seat);

    @Mapping(target = "seatId", ignore = true)
    @Mapping(target = "auditorium", ignore = true)
    Seat createToEntity(SeatCreateRequest request);    
}
