package com.docencia.repo;

import java.util.List;


import com.docencia.model.Note;

public interface INoteRepository {

    /**
     * Funcion que verifica si una note existe o no
     * @param id id de la note a verificar
     * @return true/false
     */
    public boolean exists(String id);

    /**
     * Funcion que busca una note en la bbdd o el fichero
     * @param id de la note a buscar
     * @return note buscada/null
     */
    public Note findById(String id);

    /**
     * Funcion que busca una note en la bbdd o el fichero
     * @param note nore con el id a buscar
     * @return note buscada/null
     */
    public Note find(Note note);

    /**
     * Funcion que devuelve todas las note existente
     * @return lista de notes
     */
    public List<Note> findAll();

    /**
     * Funcion que guarda una note en el fichero o bbdd
     * @param note a aniadir 
     * @return Note aniadida o null
     */
    public Note save(Note note);

    /**
     * Funcion que borra una note de la bbdd o fichero sabiendo su id
     * @param id de la note a borrar
     * @return true/false
     */
    public boolean delete(String id);
}
