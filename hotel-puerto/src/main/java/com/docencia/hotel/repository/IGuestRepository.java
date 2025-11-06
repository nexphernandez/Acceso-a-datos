package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Guest;

public interface IGuestRepository {

    boolean existsById(String id);

    Guest findById(String id);

    Set<Guest> findAll();

    Guest save(Guest guest);

    boolean deleteById(String id);
}