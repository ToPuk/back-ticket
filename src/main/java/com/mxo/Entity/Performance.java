package com.mxo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MXO_PERFORMANCE")
public class Performance {
    
    @Id
    @SequenceGenerator(
        name = "performance_id_sequence", 
        sequenceName = "performance_id_sequence", 
        allocationSize = 1, 
        initialValue = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "performance_id_sequence"
    )
    @Column(name = "PERMORMANCE_ID", nullable = false)
    private Long performanceId;

    @Column(name = "PERMORMANCE_NAME", nullable = false, length = 50)
    private String performanceName;

    @Column(name = "AUTHOR", length = 50)
    private String author;

    @Column(name = "DIRECTOR", length = 50)
    private String director;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "GENRE", length = 50)
    private String genre;

    @Column(name = "DESCRTIPTION")
    private String description;

    @Column(name = "PERFORMERS")
    private List<String> performers;

    @OneToMany(mappedBy = "performance")
    private List<PerformanceFile> performanceFiles;

    @OneToMany(mappedBy = "performance")
    private List<Screening> screenings;
}
