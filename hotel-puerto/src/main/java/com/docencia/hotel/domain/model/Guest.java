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
@Table(name="guest")
public class Guest {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="full_name")
    private String nombreCompelto;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private  String telefono;

    @OneToMany(mappedBy="guest")
    Set<Booking> bookings;

    /**
     * Constructor vacio
     */
    public Guest() {
    }

    /**
     * Constructor con el atributo principal de la Guest
     * @param id de la Guest
     */
    public Guest(String id) {
        this.id = id;
    }

    /**
     * Contructor de los atributos de la clase Guest
     * @param id de la Guest
     * @param nombreCompelto de la persona que realiza la peticion
     * @param email de la persona que realiza la peticion
     * @param telefono de la persona que realiza la peticion
     */
    public Guest(String id, String nombreCompelto, String email, String telefono) {
        this.id = id;
        this.nombreCompelto = nombreCompelto;
        this.email = email;
        this.telefono = telefono;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompelto() {
        return this.nombreCompelto;
    }

    public void setNombreCompelto(String nombreCompelto) {
        this.nombreCompelto = nombreCompelto;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Guest)) {
            return false;
        }
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
}
