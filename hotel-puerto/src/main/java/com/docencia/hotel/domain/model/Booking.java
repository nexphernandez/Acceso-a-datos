package com.docencia.hotel.domain.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name="booking")
public class Booking {
    
    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="check_in")
    private String fechaEntrada;
    
    @Column(name="check_out")
    private String fechaSalida;
    
    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room;
    
    @ManyToOne
    @JoinColumn(name="guest_id", nullable=false)
    private Guest guest;
    
    /**
     * Constructor vacio
     */
    public Booking() {
    }
    
    /**
     * Constructor con el atributo principal de la clase booking
     * @param id del booking
     */
    public Booking(String id) {
        this.id = id;
    }
    
    /**
     * Constructor con todos los atributos de la clase booking
     * @param id del booking
     * @param fechaEntrada del booking
     * @param fechaSalida del booking
     * @param guest del booking
     * @param room del booking
     */
    public Booking(String id, String fechaEntrada, String fechaSalida, Guest guest, Room room) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.room = room;
        this.guest = guest;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    
    public String getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public Room getRoom() {
        return this.room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public Guest getGuest() {
        return this.guest;
    }
    
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}