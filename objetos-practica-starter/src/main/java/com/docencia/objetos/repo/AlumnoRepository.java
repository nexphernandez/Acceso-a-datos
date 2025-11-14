package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import java.util.List;
import java.util.Optional;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface AlumnoRepository {

  /**
   * Funcion que encuentra todos los alumnos de la bbbdd
   * @return lista de alumnos
   */
  List<Alumno> findAll();

  /**
   * Funcion que busca un alumno por el id en la bbdd
   * @param id ide del alumno a buscar
   * @return lista donde se encuentra el alumno
   */
  Optional<Alumno> findById(Long id);

  /**
   * Funcion que guarfa un alumno en la bbdd
   * @param alumno alumno a guardar en la bbdd
   * @return alumno guardado/ null
   */
  Alumno save(Alumno alumno);

  /**
   * Funcion que verifica si el alumno existe sabiendo el email
   * @param email email del alumno a verificar
   * @return true/false
   */
  boolean existsByEmail(String email);

  /**
   * Funcion que elimina un alumno sabiendo su id
   * @param id id del alumno a eliminar
   */
  void deleteById(Long id);

  /**
   * Funcion que cuenta cuantos alumnos hay en la bbd
   * @return long con la cantidad de alumnos de la bbdd
   */
  long count();
}
