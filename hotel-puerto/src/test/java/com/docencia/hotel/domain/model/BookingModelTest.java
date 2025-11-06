package com.docencia.hotel.domain.model;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class BookingModelTest {

    private Booking booking;
    private Booking bookingId;
    private Booking bookingCompleto;
    private Date fechaEntrada;
    private Date fechaSalida;

    @BeforeEach
    @Transactional
    void beforeEach() {

        fechaSalida = java.sql.Date.valueOf("2025-09-25");
        fechaEntrada = java.sql.Date.valueOf("2025-09-23");

        booking = new Booking();
        bookingId = new Booking("3");
        bookingCompleto = new Booking("3", fechaEntrada, fechaSalida);
    }

    @Test
    void modificarBookingTest() {
        booking.setId("5");
        booking.setFechaEntrada(java.sql.Date.valueOf("2025-09-24"));
        booking.setFechaSalida(java.sql.Date.valueOf("2025-09-27"));
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
    }
}
