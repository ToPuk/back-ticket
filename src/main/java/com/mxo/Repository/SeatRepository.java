package com.mxo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mxo.Entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    
    @Query("SELECT s FROM Seat s WHERE s.auditorium.auditoriumId = ?1")
    List<Seat> findByAuditoriumId(Long auditoriumId);
}
