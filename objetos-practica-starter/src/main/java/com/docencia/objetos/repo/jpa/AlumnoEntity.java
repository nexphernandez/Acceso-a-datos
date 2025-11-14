package com.docencia.objetos.repo.jpa;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name="alumnos")
public class AlumnoEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  
  @Column(unique = true)
  private String email;
  
  private String ciclo;

  /**
   * Constructor vacio
   */
  public AlumnoEntity() {
  }

  /**
   * Constructor con el atributi principal de la clase
   * @param id id del alumno
   */
  public AlumnoEntity(Long id) {
    this.id = id;
  }

  /**
   * Constructor con los atributos de la clase AlumnoEntity
   * @param id id del alumno
   * @param nombre nombre del alumno
   * @param email email del alumno
   * @param ciclo ciclo del alumno
   */
  public AlumnoEntity(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return this.ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AlumnoEntity)) {
            return false;
        }
        AlumnoEntity alumnoEntity = (AlumnoEntity) o;
        return Objects.equals(id, alumnoEntity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", email='" + getEmail() + "'" +
      ", ciclo='" + getCiclo() + "'" +
      "}";
  }

}
