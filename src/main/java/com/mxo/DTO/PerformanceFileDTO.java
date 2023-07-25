package com.mxo.DTO;

import com.mxo.Entity.PerformanceFileType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class PerformanceFileDTO {
    
    @Data
    public static class PerformanceFileCreateRequest {

        @NotNull(message = "The performance id should not be null")
        private Long performanceId;

        @NotNull(message = "The file type should not be null")
        @Enumerated(EnumType.STRING)
        private PerformanceFileType fileType;

        @NotNull(message = "The file path should not be null")
        @NotEmpty(message = "The file path should not be empty")
        private String filePath;
    }
    
    @Data
    public static class PerformanceFileInfo {

        private Long performanceFileId;
        private Long performanceId;
        private PerformanceFileType fileType;
        private String filePath;
    }
}
