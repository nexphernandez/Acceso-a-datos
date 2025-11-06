/*package com.docencia.hotel.repository.jpa;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.domain.model.Guest;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
/**
@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, String>{
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
           "AND b.checkOut > :startDate AND b.checkIn < :endDate")
    Guest buscarPorRango(Date fechaEntrada, Date fechaSalida);
}
*/
