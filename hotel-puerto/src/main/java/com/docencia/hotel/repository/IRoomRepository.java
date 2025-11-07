package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Room;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IRoomRepository {

    /**
     * Comprueba si existe una habitación con el ID especificado.
     * @param id ID de la habitación a buscar
     * @return true si la habitación existe, false en caso contrario
     */
    boolean existsById(String id);

    /**
     * Busca y devuelve una habitación por su ID.
     * @param id ID de la habitación a buscar
     * @return la habitación si existe, null en caso contrario
     */
    Room findById(String id);

    /**
     * Devuelve un conjunto con todas las habitaciones registradas.
     * @return conjunto de todas las habitaciones
     */
    Set<Room> findAll();

    /**
     * Guarda una habitación nueva o actualiza una existente.
     * @param room habitación a guardar o actualizar
     * @return la habitación guardada o actualizada
     */
    Room save(Room room);

    /**
     * Elimina una habitación por su ID.
     * @param id ID de la habitación a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    boolean deleteById(String id);

    /**
     * Busca y devuelve una habitación por el ID del hotel al que pertenece.
     * @param hotelId ID del hotel
     * @return la habitación asociada al hotel, null si no existe
     */
    Room findByHotelId(String hotelId);
}
