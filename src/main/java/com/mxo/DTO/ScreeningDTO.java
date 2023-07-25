package com.mxo.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class ScreeningDTO {

    @Data
    public static class ScreeningCreateRequest {
       
        @NotNull(message = "The start date time should not be null")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime startDateTime;
        
        @NotNull(message = "The end date time should not be null")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endDateTime;

        @NotNull(message = "The performance id should not be null")
        private Long performanceId;

        @NotNull(message = "The auditorium id should not be null")
        private Long auditoriumId;
    }

    @Data
    public static class ScreeningInfo {

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime startDateTime;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endDateTime;
        private Long performanceId;
        private Long auditoriumId;
    }
}
