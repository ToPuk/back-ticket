package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.PerformanceFileDTO.PerformanceFileCreateRequest;
import com.mxo.DTO.PerformanceFileDTO.PerformanceFileInfo;
import com.mxo.Entity.PerformanceFile;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PerformanceFileDTOMapper {
    PerformanceFileDTOMapper INSTANCE = Mappers.getMapper(PerformanceFileDTOMapper.class);

    @Mapping(target = "performanceId", source = "performance.performanceId")
    PerformanceFileInfo entityToResponse(PerformanceFile performanceFile);

    @Mapping(target = "performanceFileId", ignore = true)
    @Mapping(target = "performance", ignore = true)
    PerformanceFile createToEntity(PerformanceFileCreateRequest performanceFileCreateRequest);
}
