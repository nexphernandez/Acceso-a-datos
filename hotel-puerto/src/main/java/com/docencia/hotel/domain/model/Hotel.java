package com.docencia.hotel.domain.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "address")
    private String direccion;

    @OneToMany(mappedBy="hotel")
    private Set<Room> rooms;
    
    /**
     * Constructor vacio
     */
    public Hotel() {
    }

    /**
     * Constructor con el atributo principal del hotel
     * @param id del hotel
     */
    public Hotel(String id) {
        this.id = id;
    }

    /**
     * Constructor con todos los atributos del hotel
     * @param id del hotel
     * @param nombre del hotel
     * @param direccion del hotel
     */
    public Hotel(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getnombre() {
        return this.nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdireccion() {
        return this.direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
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

}
