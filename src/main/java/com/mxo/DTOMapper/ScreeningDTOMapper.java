package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.ScreeningDTO.ScreeningCreateRequest;
import com.mxo.DTO.ScreeningDTO.ScreeningInfo;
import com.mxo.Entity.Screening;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ScreeningDTOMapper {
    ScreeningDTOMapper INSTANCE = Mappers.getMapper(ScreeningDTOMapper.class);
    
    @Mapping(target = "performanceId", source = "performance.performanceId")
    @Mapping(target = "auditoriumId", source = "auditorium.auditoriumId")
    ScreeningInfo entityToResponse(Screening screening);

    @Mapping(target = "screeningId", ignore = true)
    @Mapping(target = "auditorium", ignore = true)
    @Mapping(target = "performance", ignore = true)
    Screening createToEntity(ScreeningCreateRequest screeningCreateRequest);
}
