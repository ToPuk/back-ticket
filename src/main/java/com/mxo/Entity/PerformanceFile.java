package com.mxo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MXO_PERFORMANCE_FILE")
public class PerformanceFile {

    @Id
    @SequenceGenerator(
        name = "performanceFile_id_sequence",
        sequenceName = "performanceFile_id_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "performanceFile_id_sequence"
    )
    @Column(
        name = "PERFORMANCE_FILE_ID",
        nullable = false
    )
    private Long performanceFileId;

    @Column(
        name = "FILE_TYPE",
        nullable = false
    )
    @Enumerated(EnumType.STRING)
    private PerformanceFileType fileType;
    
    @Column(
        name = "FILE_PATH"
    )
    private String filePath;

    @ManyToOne
    @JoinColumn(
        name = "PERFORMANCE_ID",
        foreignKey = @ForeignKey(name = "performance_id_fk"),
        nullable = false
    )
    private Performance performance;
}
