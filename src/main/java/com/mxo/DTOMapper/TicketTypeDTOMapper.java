package com.mxo.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.mxo.DTO.TicketTypeDTO.TicketTypeCreateRequest;
import com.mxo.DTO.TicketTypeDTO.TicketTypeInfo;
import com.mxo.Entity.TicketType;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TicketTypeDTOMapper {
    TicketTypeDTOMapper INSTANCE = Mappers.getMapper(TicketTypeDTOMapper.class);
    
    TicketTypeInfo entityToResponse(TicketType ticketType);

    @Mapping(target = "ticketTypeId", ignore = true)
    TicketType createToEntity(TicketTypeCreateRequest ticketTypeCreateRequest);
}
