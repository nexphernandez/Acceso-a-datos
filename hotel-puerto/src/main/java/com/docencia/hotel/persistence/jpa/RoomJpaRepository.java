package com.docencia.hotel.persistence.jpa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.domain.model.Room;
import com.docencia.hotel.repository.IGuestRepository;
import com.docencia.hotel.repository.IRoomRepository;
import com.docencia.hotel.repository.jpa.IGuestJpaRepository;
import com.docencia.hotel.repository.jpa.IRoomJpaRepository;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public class RoomJpaRepository implements IRoomRepository{

    private final IRoomJpaRepository repository;

    public RoomJpaRepository(IRoomJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public Room findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<Room> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public boolean deleteById(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public Room save(Room room) {
        if (room.getId() == null || room.getId().isBlank()) {
            room.setId(UUID.randomUUID().toString());
        }
        return repository.save(room);
    }

    @Override
    public Set<Room> findByHotelId(String hotelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByHotelId'");
    }
    
}
