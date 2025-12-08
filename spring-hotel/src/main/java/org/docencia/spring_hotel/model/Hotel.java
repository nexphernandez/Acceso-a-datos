package org.docencia.spring_hotel.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Table(name="hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="direccion")
    private String direccion;

    @OneToMany(mappedBy="hotel")
    private List<Room> habitaciones;

    /**
     * Cosntructor vacio
     */
    public Hotel() {
    }

    /**
     * Contructo de los atributos de la clase hotel
     * @param id identificador del hotel
     * @param nombre nombre del hotel
     * @param direccion direccion del hotel
     * @param habitaciones habitaciones del hotel
     */
    public Hotel(Long id, String nombre, String direccion, List<Room> habitaciones) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = habitaciones;
    }

    /**
     * Contructor con la identificador de la clase
     * @param id identificador del hotel
     */
    public Hotel(Long id) {
        this.id = id;
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

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Room> getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(List<Room> habitaciones) {
        this.habitaciones = habitaciones;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
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
            ", direccion='" + getDireccion() + "'" +
            ", habitaciones='" + getHabitaciones() + "'" +
            "}";
    }

}
