package com.docencia.hotel.persistence.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.hotel.domain.model.Hotel;
import com.docencia.hotel.repository.IHotelRepository;

import jakarta.transaction.Transactional;


@SpringBootTest
@ActiveProfiles("test")
class HotelJpaRepositoryTest {
    
    @Autowired
    private IHotelRepository hotelRepository;

    private Hotel hotelBase;

    @BeforeEach
    @Transactional
    void beforeEach(){
        hotelBase = new Hotel("5","Las Aguilas","Calle las aguilas");
        
        assertThat(hotelBase.getId()).isNotNull();
    }


    @Test
    @Transactional
    void saveNullTest(){
        Hotel hotel = new Hotel();
        Hotel hotelsaved = hotelRepository.save(hotel);
        
        Assertions.assertNotNull(hotelsaved);
    }

    @Test
    @Transactional
    void saveBlankTest(){
        Hotel hotel = new Hotel("");
        Hotel hotelsaved = hotelRepository.save(hotel);
        
        Assertions.assertNotNull(hotelsaved);
    }

    @Test
    @Transactional
    void findByIdTest(){
        hotelRepository.save(hotelBase);
        String id = hotelBase.getId();
        boolean exist = hotelRepository.existsById(id);
        assertThat(exist).isTrue();
    }

    @Test
    @Transactional
    void findAllTest(){
        int tamanio = hotelRepository.findAll().size();
        Assertions.assertEquals( 1,tamanio);
        hotelRepository.save(hotelBase);
        Assertions.assertEquals( 2,hotelRepository.findAll().size());

    }


    @Test
    @Transactional
    void deleteByIdTest(){
        hotelRepository.save(hotelBase);
        String id = hotelBase.getId();
        boolean borrada = hotelRepository.deleteById(id);
        assertThat(borrada).isTrue();
        assertThat(hotelRepository.existsById(id)).isFalse();
        assertThat(hotelRepository.findById(id)).isNull();
    }

    @Test
    @Transactional
    void deleteDontExistId(){
        boolean borrada = hotelRepository.deleteById("jhjhghje");
        assertThat(borrada).isFalse();
    }
}
