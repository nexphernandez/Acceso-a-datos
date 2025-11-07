package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Booking;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IBookingRepository {

    /**
     * Comprueba si existe una reserva con el ID especificado.
     * @param id ID de la reserva a buscar
     * @return true si la reserva existe, false en caso contrario
     */
    boolean existsById(String id);

    /**
     * Busca y devuelve una reserva por su ID.
     * @param id ID de la reserva a buscar
     * @return la reserva si existe, null en caso contrario
     */
    Booking findById(String id);

    /**
     * Devuelve un conjunto con todas las reservas registradas.
     * @return conjunto de todas las reservas
     */
    Set<Booking> findAll();

    /**
     * Guarda una reserva nueva o actualiza una existente.
     * @param booking reserva a guardar o actualizar
     * @return la reserva guardada o actualizada
     */
    Booking save(Booking booking);

    /**
     * Elimina una reserva por su ID.
     * @param id ID de la reserva a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    boolean deleteById(String id);

    /**
     * Busca una reserva para una habitación específica en un rango de fechas.
     * @param roomId ID de la habitación
     * @param checkin fecha de entrada en formato String
     * @param checkout fecha de salida en formato String
     * @return la reserva encontrada, null si no existe ninguna
     */
    Booking findByRoomIdAndDateRange(String roomId, String checkin, String checkout);
}
