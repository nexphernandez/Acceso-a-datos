package org.docencia.spring_hotel.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="numeroHabitacion")
    private int numeroHabitacion;

    @Column(name="tipo")
    private String tipo;
    
    @Column(name="precioPorNoche")
    private float precioPorNoche;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @OneToOne(mappedBy = "room")
    private Booking booking;


    /**
     * Cosntructor vacio
     */
    public Room() {
    }

    /**
     * Cosntructor con los atributos del room
     * @param id identificador del rom
     * @param numeroHabitacion nomero de habitaion del rom
     * @param tipo  tipo del rom
     * @param precioPorNoche precio por noche del rom
     * @param hotel hotel del rom
     * @param booking boking del rom
     */
    public Room(Long id, int numeroHabitacion, String tipo, float precioPorNoche, Hotel hotel, Booking booking) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.hotel = hotel;
        this.booking = booking;
    }

    /**
     * Contructor con la identificador de la clase
     * @param id identificador de Room
     */
    public Room(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroHabitacion() {
        return this.numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
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

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numeroHabitacion='" + getNumeroHabitacion() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", precioPorNoche='" + getPrecioPorNoche() + "'" +
            ", hotel='" + getHotel() + "'" +
            ", booking='" + getBooking() + "'" +
            "}";
    }
    
}
