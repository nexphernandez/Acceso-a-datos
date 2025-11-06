package com.docencia.hotel.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Guest;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Repository
public interface IGuestJpaRepository extends JpaRepository<Guest, String>{

}
