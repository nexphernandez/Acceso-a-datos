package com.docencia.objetos.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, Long> {
  /**
   * Funcion que verifica que un alumno exita sabiendo el email
   * @param email email del alumno
   * @return true/false
   */
  boolean existsByEmail(String email);

  
}
