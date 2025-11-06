package com.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class GuestModelTest {

    private Guest guest;
    private Guest guestId;
    private Guest guestCompleto;

    @BeforeEach
    @Transactional
    void beforeEach() {
        guest = new Guest();
        guestId = new Guest("3");
        guestCompleto = new Guest("3", "sara", "sara@gmail.com","+34 645845268");

    }

    @Test
    void modificarGuestTest() {
        guest.setId("4");
        guest.setNombreCompelto("Nico");
        guest.setEmail("nico@gmail.com");
        guest.setTelefono("+34 857598547");
        
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(guestCompleto.equals(guestId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(guest.equals(guestCompleto));
    }


    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(guest.equals("guest"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(guestId.equals(guestId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(guest.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(guestCompleto.getId().equals("3"));
        Assertions.assertTrue(guestCompleto.getNombreCompelto().equals("sara"));
        Assertions.assertTrue(guestCompleto.getEmail().equals("sara@gmail.com"));
        Assertions.assertTrue(guestCompleto.getTelefono().equals("+34 645845268"));
    }
}
