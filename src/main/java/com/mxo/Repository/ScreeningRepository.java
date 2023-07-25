package com.mxo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mxo.Entity.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    
}
