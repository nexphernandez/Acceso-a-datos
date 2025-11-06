package com.docencia.hotel.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.domain.model.Room;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, String>{
    Guest buscarPorHabitacion(Room room);
    Guest buscarPorRango(Date fechaEntrada, Date fechaSalida);
}
