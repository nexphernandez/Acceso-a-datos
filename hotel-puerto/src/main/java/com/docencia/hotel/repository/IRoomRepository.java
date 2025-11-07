package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Room;

public interface IRoomRepository {
    
    boolean existsById(String id);

    Room findById(String id);

    Set<Room> findAll();

    Room save(Room room);

    boolean deleteById(String id);

    Room findByHotelId(String hotelId);
}
