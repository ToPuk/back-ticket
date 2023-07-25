package com.mxo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mxo.Entity.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long>{
    
}
