package com.docencia.hotel.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
public class Hotel {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

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
     * @param name del hotel
     * @param address del hotel
     */
    public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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
