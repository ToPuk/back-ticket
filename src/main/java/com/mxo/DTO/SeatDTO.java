package com.mxo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class SeatDTO {
    
    @Data
    public static class SeatCreateRequest {
        
        @NotNull(message = "The seat number should not be null")
        private Integer seatNumber;

        @NotNull(message = "The row number should not be null")
        private Integer rowNumber;

        @NotNull(message = "The floor number should not be null")
        private Integer floorNumber;
        
        @NotNull(message = "The auditorium id should not be null")
        private Long auditoriumId;
    }
    
    @Data
    public static class SeatInfo {
        
        private Long seatId;
        private Integer seatNumber;
        private Integer rowNumber;
        private Integer floorNumber;
        private Long auditoriumId;
    }
}
