package com.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

class RoomModelTest {

    private Room room;
    private Room roomId;
    private Room roomCompleto;

    @BeforeEach
    @Transactional
    void beforeEach() {
        room = new Room();
        roomId = new Room("3");
        roomCompleto = new Room("3", 205, "single",15);

    }

    @Test
    void modificarroomTest() {
        room.setId("5");
        room.setNumero(25);
        room.setPrecioPorNoche(250);
        room.setTipo("double");
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(roomCompleto.equals(roomId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(room.equals(roomCompleto));
    }


    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(room.equals("room"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(roomId.equals(roomId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(room.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(roomCompleto.getId().equals("3"));
        Assertions.assertTrue(roomCompleto.getTipo().equals("single"));
        Assertions.assertTrue(roomCompleto.getNumero() == 205);
        Assertions.assertTrue(roomCompleto.getPrecioPorNoche() == 15);
    }
}
