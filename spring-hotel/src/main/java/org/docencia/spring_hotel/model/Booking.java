package org.docencia.spring_hotel.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="fechaEntrada")
    private LocalDate fechaEntrada; 
    @Column(name="fechaSalida")
    private LocalDate fechaSalida; 

    @OneToOne
    @JoinColumn(name = "room_id")  
    private Room room;

    @OneToOne
    @JoinColumn(name = "guest_id")  
    private Guest guest;


    /**
     * Cosntructor vacio
     */
    public Booking() {
    }

    /**
     * Contructor con la identificador de la clase
     * @param id identificador de bokings
     */
    public Booking(Long id) {
        this.id = id;
    }

    /**
     * Cosntructor con todos los atributos de la clase
     * @param id identificador de la clase booking
     * @param fechaEntrada fecha de entrade de la clase booking
     * @param fechaSalida fecha de salida de la clase booking
     * @param room room de la clase booking
     * @param guest guest de la clase booking
     */
    public Booking(Long id, LocalDate fechaEntrada, LocalDate fechaSalida, Room room, Guest guest) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.room = room;
        this.guest = guest;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
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
        return Objects.equals(id, booking.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fechaEntrada='" + getFechaEntrada() + "'" +
            ", fechaSalida='" + getFechaSalida() + "'" +
            ", room='" + getRoom() + "'" +
            ", guest='" + getGuest() + "'" +
            "}";
    }
    
}
