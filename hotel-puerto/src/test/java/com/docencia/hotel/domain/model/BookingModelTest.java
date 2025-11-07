package com.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class BookingModelTest {

    private Booking booking;
    private Booking bookingId;
    private Booking bookingCompleto;
    private String fechaEntrada;
    private String fechaSalida;
    private Guest guest;
    private Room room;

    @BeforeEach
    @Transactional
    void beforeEach() {

        fechaEntrada = "2025, 9, 23";
        fechaSalida = "2025, 9, 25";
        guest = new Guest();
        room = new Room();
        booking = new Booking();
        bookingId = new Booking("3");
        bookingCompleto = new Booking("3", fechaEntrada, fechaSalida,guest,room);
    }

    @Test
    void modificarBookingTest() {
        booking.setId("5");
        booking.setFechaEntrada("2025, 9, 24");
        booking.setFechaSalida("2025, 9, 27");
        booking.setGuest(guest);
        booking.setRoom(room);
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(bookingCompleto.equals(bookingId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(booking.equals(bookingCompleto));
    }

    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(booking.equals("Booking"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(bookingId.equals(bookingId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(booking.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(bookingCompleto.getId().equals("3"));
        Assertions.assertTrue(bookingCompleto.getFechaEntrada().equals(fechaEntrada));
        Assertions.assertTrue(bookingCompleto.getFechaSalida().equals(fechaSalida));
        Assertions.assertTrue(bookingCompleto.getGuest().equals(guest));
        Assertions.assertTrue(bookingCompleto.getRoom().equals(room));
    }
}
