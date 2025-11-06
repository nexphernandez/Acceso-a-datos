package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Hotel;

public interface IHotelRepository {

    boolean existsById(String id);

    Hotel findById(String id);

    Set<Hotel> findAll();

    Hotel save(Hotel hotel);

    boolean deleteById(String id);
    
}
