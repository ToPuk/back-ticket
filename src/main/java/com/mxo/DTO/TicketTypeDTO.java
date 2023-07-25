package com.mxo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class TicketTypeDTO {

    @Data
    public static class TicketTypeCreateRequest {

        @NotNull(message = "The ticket type name should not be null")
        @NotEmpty(message = "The ticket type name should not be empty")
        public String ticketTypeName;
        @NotNull(message = "The ticket type price should not be null")
        public Integer ticketPrice;
    }

    @Data
    public static class TicketTypeInfo {
        
        public Long ticketTypeId;
        public String ticketTypeName;
        public String ticketPrice;
    }
}
