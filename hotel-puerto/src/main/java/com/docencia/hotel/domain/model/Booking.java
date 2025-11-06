package com.docencia.hotel.domain.model;
import java.util.Date;
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
    private Date fechaEntrada;

    @Column(name="check_out")
    private Date fechaSalida;

    @ManyToOne
    @JoinColumn(name="room_id",nullable=false)
    private Room room;

    @ManyToOne
    @JoinColumn(name="gues_id", nullable=false)
    private Guest guest;

    /**
     * Contructor vacio
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
     */
    public Booking(String id, Date fechaEntrada, Date fechaSalida) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
