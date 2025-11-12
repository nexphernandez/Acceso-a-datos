package com.docencia.objetos.domain;

import java.util.Objects;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class Alumno {
    private Long id;
    private String nombre;
    private String email;
    private String ciclo;

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", nombre='" + getNombre() + "'"
                + ", email='" + getEmail() + "'"
                + ", ciclo='" + getCiclo() + "'"
                + "}";
    }

    /**
     * Constructor vacio
     */
    public Alumno() {
    }

    /**
     * Constructor con el atributo principal de la clase
     *
     * @param id id del alumno
     */
    public Alumno(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los atributos de la clase
     *
     * @param id id del alumno
     * @param nombre nombre del alumno
     * @param email email del alumno
     * @param ciclo ciclo del alumno
     */
    public Alumno(Long id, String nombre, String email, String ciclo) {
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
        if (o == this) {
            return true;
        }
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        if (id == null || alumno.getId() == null) {
          return  false;
        }
        return Objects.equals(id, alumno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
