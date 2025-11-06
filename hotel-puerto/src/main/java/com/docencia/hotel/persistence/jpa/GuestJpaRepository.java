package com.docencia.hotel.persistence.jpa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Guest;
import com.docencia.hotel.repository.IGuestRepository;
import com.docencia.hotel.repository.jpa.IGuestJpaRepository;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public class GuestJpaRepository implements IGuestRepository{

    private final IGuestJpaRepository repository;

    public GuestJpaRepository(IGuestJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public Guest findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<Guest> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getId() == null || guest.getId().isBlank()) {
            guest.setId(UUID.randomUUID().toString());
        }
        return repository.save(guest);
    }

    @Override
    public boolean deleteById(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
    
}
