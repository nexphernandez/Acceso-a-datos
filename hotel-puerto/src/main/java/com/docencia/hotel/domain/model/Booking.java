package com.docencia.hotel.domain.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Objects;

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

    /**
     * Contructor vacio
     */
    public Booking() {
    }

    
    public Booking(String id) {
        this.id = id;
    }

    
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
