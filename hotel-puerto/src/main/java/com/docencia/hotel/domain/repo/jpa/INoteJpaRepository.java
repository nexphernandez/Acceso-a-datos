package com.docencia.hotel.domain.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.model.Note;

import java.util.Optional;

@Repository
public interface INoteJpaRepository extends JpaRepository<Note, String> {

    Optional<Note> findFirstByTitle(String title);

}
