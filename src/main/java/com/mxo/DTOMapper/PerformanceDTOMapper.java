package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.PerformanceDTO.PerformanceCreateRequest;
import com.mxo.DTO.PerformanceDTO.PerformanceInfo;
import com.mxo.DTO.PerformanceDTO.PerformanceUpdateRequest;
import com.mxo.Entity.Performance;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PerformanceDTOMapper {
    PerformanceDTOMapper INSTANCE = Mappers.getMapper(PerformanceDTOMapper.class);

    PerformanceInfo entityToResponse(Performance performance);

    @Mapping(target = "performanceId", ignore = true)
    @Mapping(target = "performanceFiles", ignore = true)
    Performance createToEntity(PerformanceCreateRequest request);

    @Mapping(target = "performanceFiles", ignore = true)
    void updateToEntity(PerformanceUpdateRequest request, @MappingTarget Performance performance);
}
