package com.docencia.hotel.domain.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name="room")
public class Room {
    
    @Id
    @Column(name="id")
    private String id;

    @Column(name = "number")
    private int numero;

    @Column(name="type")
    private String tipo;

    @Column(name="price_per_night")
    private float precioPorNoche;

    @ManyToOne
    @JoinColumn(name="hotel_id",nullable=false)
    private Hotel hotel;

    @OneToMany(mappedBy="room")
    private Set<Booking> bookings;
    
    /**
     * Constructor vacio
     */
    public Room() {
    }

    /**
     * Constructor con el atributo principal de la Room
     * @param id de la Room
     */
    public Room(String id) {
        this.id = id;
    }

    /**
     * Constructor con todos los atributos de la clase Room
     * @param id de la Room
     * @param numero de la Room
     * @param tipo de la Room
     * @param precioPorNoche de la Room
     */
    public Room(String id, int numero, String tipo, float precioPorNoche) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public void setPrecioPorNoche(float precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
