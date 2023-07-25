package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.AuditoriumDTO.AuditoriumCreateRequest;
import com.mxo.DTO.AuditoriumDTO.AuditoriumInfo;
import com.mxo.Entity.Auditorium;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuditoriumDTOMapper {
    AuditoriumDTOMapper INSTANCE = Mappers.getMapper(AuditoriumDTOMapper.class);

    AuditoriumInfo entityToResponse(Auditorium auditorium);

    @Mapping(target = "auditoriumId", ignore = true)
    @Mapping(target = "seats", ignore = true)
    Auditorium createToEntity(AuditoriumCreateRequest request);
}
