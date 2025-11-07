package com.docencia.hotel.repository;

import java.time.LocalDate;
import java.util.Set;
import com.docencia.hotel.domain.model.Booking;

public interface IBookingRepository {
    boolean existsById(String id);
    Booking findById(String id);
    Set<Booking> findAll();
    Booking save(Booking booking);
    boolean deleteById(String id);
    Booking findByRoomIdAndDateRange(String roomId, String checkin, String checkout);
}