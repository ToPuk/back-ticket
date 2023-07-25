package com.mxo.DTO;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class PerformanceDTO {
    
    @Data
    public static class PerformanceCreateRequest {

        @NotNull(message = "The performance name should not be null")
        @NotEmpty(message = "The performance name should not be empty")
        private String performanceName;
        private String author;
        private String director;
        @NotNull(message = "The performance duration should not be null")
        private Integer duration;
        private String genre;
        private String description;
        private List<String> performers;
    }

    @Data
    public static class PerformanceInfo {

        private Long performanceId;
        private String performanceName;
        private String author;
        private String director;
        private Integer duration;
        private String genre;
        private String description;
        private List<String> performers;
    }

    @Data
    public static class PerformanceUpdateRequest {

        private Long performanceId;
        private String performanceName;
        private String author;
        private String director;
        private Integer duration;
        private String genre;
        private String description;
        private List<String> performers;
    }
}
