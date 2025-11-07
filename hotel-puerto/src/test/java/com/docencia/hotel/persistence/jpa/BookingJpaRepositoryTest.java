package com.docencia.hotel.persistence.jpa;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.hotel.domain.model.Booking;
import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.domain.model.Hotel;
import com.docencia.hotel.domain.model.Room;
import com.docencia.hotel.repository.IBookingRepository;
import com.docencia.hotel.repository.IGuestRepository;
import com.docencia.hotel.repository.IHotelRepository;
import com.docencia.hotel.repository.IRoomRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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

    @Autowired
    private EntityManager entityManager;

    private Booking testBooking;
    private Hotel testHotel;
    private Room testRoom;
    private Guest testGuest;
    private String checkin;
    private String checkout;

    @BeforeEach
    void beforeEach() {
        checkin = "2025, 9, 23";
        checkout = "2025, 9, 25";

        testHotel = hotelRepository.save(new Hotel("h1", "Test Hotel", "Test City"));
        testRoom = roomRepository.save(new Room("R105", 101, "Single", 100.0f, testHotel));
        testGuest = guestRepository.save(new Guest("g1", "John Doe", "john@example.com", "123456"));
        testBooking = new Booking("B3", checkin, checkout, testGuest, testRoom);
        bookingRepository.save(testBooking);
    }

    @AfterEach
    void afterEach() {

        entityManager.clear();

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
        String newCheckout = "2025, 9, 27";
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

    @Test
    @Transactional
    void deleteDontExistId() {
        boolean borrada = bookingRepository.deleteById("jhjhghje");
        assertThat(borrada).isFalse();
    }

    @Test
    @Transactional
    void saveNullTest() {
        Booking booking = new Booking(null);
        try {
            bookingRepository.save(booking);
            Assertions.fail("La Excepcion no fue lanzada.");
        } catch (DataIntegrityViolationException expectedException) {
        }
    }

    @Test
    @Transactional
    void saveBlankTest() {
        Booking bookingWithBlankId = new Booking("", checkin, checkout, testGuest, testRoom);
        Booking savedBooking = bookingRepository.save(bookingWithBlankId);
        Assertions.assertNotNull(savedBooking);
        assertThat(savedBooking.getId()).isNotBlank();
    }

}
