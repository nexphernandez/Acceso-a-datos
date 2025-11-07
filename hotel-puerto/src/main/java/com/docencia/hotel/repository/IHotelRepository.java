package com.docencia.hotel.repository;

import java.util.Set;

import com.docencia.hotel.domain.model.Hotel;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IHotelRepository {

    /**
     * Comprueba si existe un hotel con el ID especificado.
     * @param id ID del hotel a buscar
     * @return true si el hotel existe, false en caso contrario
     */
    boolean existsById(String id);

    /**
     * Busca y devuelve un hotel por su ID.
     * @param id ID del hotel a buscar
     * @return el hotel si existe, null en caso contrario
     */
    Hotel findById(String id);

    /**
     * Devuelve un conjunto con todos los hoteles registrados.
     * @return conjunto de todos los hoteles
     */
    Set<Hotel> findAll();

    /**
     * Guarda un hotel nuevo o actualiza uno existente.
     * @param hotel hotel a guardar o actualizar
     * @return el hotel guardado o actualizado
     */
    Hotel save(Hotel hotel);

    /**
     * Elimina un hotel por su ID.
     * @param id ID del hotel a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    boolean deleteById(String id);
}
