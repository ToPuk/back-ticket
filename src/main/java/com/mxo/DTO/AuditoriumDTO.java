package com.mxo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class AuditoriumDTO {

    @Data
    public static class AuditoriumCreateRequest {

        @NotNull(message = "The auditorium name should not be null")
        @NotEmpty(message = "The auditorium name should not be empty")
        private String auditoriumName;
        
        @NotNull(message = "The total seat number should not be null")
        private Integer totalSeats;
    }

    @Data
    public static class AuditoriumInfo {

        private Long auditoriumId;
        private String auditoriumName;
        private Integer totalSeats;
    }
}

