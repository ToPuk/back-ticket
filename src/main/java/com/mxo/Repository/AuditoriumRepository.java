package com.mxo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mxo.Entity.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long>{
    
}
