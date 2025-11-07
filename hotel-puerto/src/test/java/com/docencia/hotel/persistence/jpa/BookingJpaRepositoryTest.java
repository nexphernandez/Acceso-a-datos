package com.docencia.hotel.persistence.jpa;

import java.time.LocalDate;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.domain.model.Hotel;
import com.docencia.hotel.domain.model.Room;
import com.docencia.hotel.repository.IBookingRepository;
import com.docencia.hotel.repository.IGuestRepository;
import com.docencia.hotel.repository.IHotelRepository;
import com.docencia.hotel.repository.IRoomRepository;
import org.junit.jupiter.api.AfterEach;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class BookingJpaRepositoryTest {
    
    @Autowired
    private IBookingRepository bookingRepository;
    
    @Autowired
    private IHotelRepository hotelRepository;
    
    @Autowired
    private IRoomRepository roomRepository;
    
    @Autowired
    private IGuestRepository guestRepository;
    
    private Booking testBooking;
    private Hotel testHotel;
    private Room testRoom;
    private Guest testGuest;
    private LocalDate checkin;
    private LocalDate checkout;
    
    @BeforeEach
    void beforeEach() {
        // Usando LocalDate es mucho más simple y claro
        checkin = LocalDate.of(2025, 9, 23);
        checkout = LocalDate.of(2025, 9, 25);
        
        testHotel = hotelRepository.save(new Hotel("h1", "Test Hotel", "Test City"));
        testRoom = roomRepository.save(new Room("R105", 101, "Single", 100.0f, testHotel));
        testGuest = guestRepository.save(new Guest("g1", "John Doe", "john@example.com", "123456"));
        testBooking = new Booking("B3", checkin, checkout, testGuest, testRoom);
        bookingRepository.save(testBooking);
    }
    
    @AfterEach
    void afterEach() {
        bookingRepository.deleteById("B3");
        roomRepository.deleteById("R105");
        guestRepository.deleteById("g1");
        hotelRepository.deleteById("h1");
    }
    
    @Test
    void testSaveBooking() {
        Booking booking = new Booking("b2", checkin, checkout, testGuest, testRoom);
        Booking saved = bookingRepository.save(booking);
        
        assertNotNull(saved);
        assertEquals("b2", saved.getId());
        
        bookingRepository.deleteById("b2");
    }
    
    @Test
    void testFindBookingById() {
        Booking found = bookingRepository.findById("B3");
        
        assertNotNull(found);
        assertEquals("B3", found.getId());
        assertEquals(checkin, found.getFechaEntrada());
        assertEquals(checkout, found.getFechaSalida());
    }
    
    @Test
    void testFindAllBookings() {
        Set<Booking> bookings = new HashSet<>(bookingRepository.findAll());
        
        assertNotNull(bookings);
        assertTrue(bookings.size() > 0);
    }
    
    @Test
    void testUpdateBooking() {
        LocalDate newCheckout = LocalDate.of(2025, 9, 27);
        testBooking.setFechaSalida(newCheckout);
        
        Booking updated = bookingRepository.save(testBooking);
        
        assertEquals(newCheckout, updated.getFechaSalida());
    }
    
    @Test
    void testExistsById() {
        assertTrue(bookingRepository.existsById("B3"));
        assertFalse(bookingRepository.existsById("nonexistent"));
    }
    
    @Test
    void testFindByRoomIdAndDateRange() {
        Booking booking = bookingRepository.findByRoomIdAndDateRange(
            testRoom.getId(), checkin, checkout);
        
        assertNotNull(booking);
        assertEquals("B3", booking.getId());
        assertEquals(testRoom.getId(), booking.getRoom().getId());
    }
}