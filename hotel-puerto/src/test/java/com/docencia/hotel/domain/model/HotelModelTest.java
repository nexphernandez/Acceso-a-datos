package com.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class HotelModelTest {

    private Hotel hotel;
    private Hotel hotelId;
    private Hotel hotelCompleto;

    @BeforeEach
    @Transactional
    void beforeEach() {
        hotel = new Hotel();
        hotelId = new Hotel("3");
        hotelCompleto = new Hotel("3", "hotel", "direccion");

    }

    @Test
    void modificarHotelTest() {
        hotel.setId("3");
        hotel.setAddress("direccion");
        hotel.setName("hotel");
        
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(hotelCompleto.equals(hotelId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(hotel.equals(hotelCompleto));
    }


    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(hotel.equals("hotel"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(hotelId.equals(hotelId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(hotel.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(hotelCompleto.getId().equals("3"));
        Assertions.assertTrue(hotelCompleto.getName().equals("hotel"));
        Assertions.assertTrue(hotelCompleto.getAddress().equals("direccion"));
    }
}
