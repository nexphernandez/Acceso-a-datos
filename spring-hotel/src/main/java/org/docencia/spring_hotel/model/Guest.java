package org.docencia.spring_hotel.model;

import java.util.Objects;

import org.docencia.spring_hotel.model.nosql.GuestPreferences;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;
    @Column(name = "nombreCompleto")
    private String nombreCompleto;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;

    @Transient
    private GuestPreferences preferences;

    @OneToOne(mappedBy = "guest")
    private Booking booking;

    /**
     * Cosntructor vacio
     */
    public Guest() {
    }

    /**
     * Constructor con todos los atributos de la clase Guest
     * @param id identificador del guest
     * @param nombreCompleto nombre completo del guest
     * @param email email del guest
     * @param telefono telefono del guest
     * @param preferences preferencias del guest
     * @param booking booking del guest
     */
    public Guest(String id, String nombreCompleto, String email, String telefono, GuestPreferences preferences, Booking booking) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.preferences = preferences;
        this.booking = booking;
    }

    /**
     * Contructor con la identificador de la clase
     * @param id identificador de guest
     */
    public Guest(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public GuestPreferences getPreferences() {
        return this.preferences;
    }

    public void setPreferences(GuestPreferences preferences) {
        this.preferences = preferences;
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
        if (!(o instanceof Guest)) {
            return false;
        }
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombreCompleto='" + getNombreCompleto() + "'" +
            ", email='" + getEmail() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", preferences='" + getPreferences() + "'" +
            ", booking='" + getBooking() + "'" +
            "}";
    }
    
}
