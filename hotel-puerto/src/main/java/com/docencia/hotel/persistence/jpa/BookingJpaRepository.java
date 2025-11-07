package com.docencia.hotel.persistence.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.repository.IBookingRepository;
import com.docencia.hotel.repository.jpa.IBookingJpaRepository;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public class BookingJpaRepository implements IBookingRepository {
    
    private final IBookingJpaRepository repository;
    
    public BookingJpaRepository(IBookingJpaRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }
    
    @Override
    public Booking findById(String id) {
        return repository.findById(id).orElse(null);
    }
    
    @Override
    public Set<Booking> findAll() {
        return new HashSet<>(repository.findAll());
    }
    
    @Override
    public boolean deleteById(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
    
    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null || booking.getId().isBlank()) {
            booking.setId(UUID.randomUUID().toString());
        }
        return repository.save(booking);
    }
    
    @Override
    public Booking findByRoomIdAndDateRange(String roomId, String startDate, String endDate) {
        List<Booking> bookings = repository.findByRoomIdAndDateRange(roomId, startDate, endDate);
        return bookings.get(0);
    }
}