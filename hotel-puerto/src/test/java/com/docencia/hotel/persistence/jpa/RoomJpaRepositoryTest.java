package com.docencia.hotel.persistence.jpa;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.hotel.domain.model.Hotel;
import com.docencia.hotel.domain.model.Room;
import com.docencia.hotel.repository.IHotelRepository;
import com.docencia.hotel.repository.IRoomRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class RoomJpaRepositoryTest {

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IHotelRepository hotelRepository;

    private Room roomBase;
    private Hotel hotelBase;
    private Hotel savedHotel;
    private Room savedRoom;

    @BeforeEach
    @Transactional
    void beforeEach() {
        hotelBase = new Hotel("5", "Las palmas", "Las palmas");
        roomBase = new Room("3", 4, "nico", 253, hotelBase);
        assertThat(roomBase.getId()).isNotNull();
        assertThat(hotelBase.getId()).isNotNull();
        savedHotel = hotelRepository.save(hotelBase);
        savedRoom = roomRepository.save(roomBase);
    }

    @Test
    @Transactional
    void saveValidRoomTest() {
        
        assertThat(savedRoom).isNotNull();
        assertThat(savedRoom.getId()).isNotNull();
        assertThat(savedRoom.getHotel()).isEqualTo(savedHotel);
    }

    @Test
    @Transactional
    void saveNullTest() {
        Room room = new Room(); 
        try {
            roomRepository.save(room);
            Assertions.fail("La Excepcion no fue lanzada.");
        } catch (DataIntegrityViolationException expectedException) {}
    }

    @Test
    @Transactional
    void saveBlankTest() {
        Room roomWithBlankId = new Room("", 4, "test", 253, savedHotel);
        Room savedRoom = roomRepository.save(roomWithBlankId);
        Assertions.assertNotNull(savedRoom);
        assertThat(savedRoom.getId()).isNotBlank();
    }

    @Test
    @Transactional
    void findByIdTest(){
        roomRepository.save(savedRoom);
        String id = roomBase.getId();
        Room exist = roomRepository.findById(id);
        Assertions.assertNotNull(exist);
    }

    @Test
    @Transactional
    void findAllTest() {
        roomBase.setHotel(savedHotel);
        roomRepository.save(roomBase);

        int finalCount = roomRepository.findAll().size();

        assertThat(finalCount).isGreaterThanOrEqualTo(1);
    }

    @Test
    @Transactional
    void deleteByIdTest() {
        roomBase.setHotel(savedHotel);
        roomRepository.save(roomBase);

        String id = roomBase.getId();
        roomRepository.deleteById(id);

        assertThat(roomRepository.existsById(id)).isFalse();

    }

    
        @Test
        @Transactional
        void findByHotelIdTest(){
            roomRepository.save(savedRoom);
            Hotel hoteSaved = hotelRepository.save(hotelBase);
            String id = hoteSaved.getId();
            Room exist = roomRepository.findByHotelId(id);
            Assertions.assertNotNull(exist);
        }
        
    @Test
    @Transactional
    void deleteDontExistId() {
        boolean borrada = roomRepository.deleteById("jhjhghje");
        assertThat(borrada).isFalse();
    }
}