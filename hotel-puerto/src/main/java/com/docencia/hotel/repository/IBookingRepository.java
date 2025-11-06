package com.docencia.hotel.repository;

import java.sql.Date;
import java.util.Set;

import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.domain.model.Room;

public interface IBookingRepository {

    boolean existsById(String id);

    Booking findById(String id);

    Set<Booking> findAll();

    Booking save(Booking booking);

    boolean deleteById(String id);

    Set<Booking> findByRoomIdAndDateRange(String roomId, Date startDate, Date endDate);

    Guest buscarPorHabitacion(Room room);
    
    Guest buscarPorRango(Date fechaEntrada, Date fechaSalida);
}
