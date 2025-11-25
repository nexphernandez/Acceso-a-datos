package com.docencia.hotel.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Booking;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, String> {
    
    @Query("SELECT b FROM Booking as b WHERE b.room.id = :roomId " +
           "AND b.fechaSalida > :startDate AND b.fechaEntrada < :endDate")
    List<Booking> findByRoomIdAndDateRange(
        @Param("roomId") String roomId, 
        @Param("startDate") String startDate, 
        @Param("endDate") String endDate
    );
}