package com.docencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 * Clase note que almacena informacion
 * 
 * @author nexphernandez
 * @version 1.0.0
 */
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name ="id",length = 64)
    @NotBlank
    private String id;

    
    @NotBlank
    @Size(max = 200)
    @Column(name ="titlulo")
    private String title;

    @NotBlank
    @Column(name ="contenido", nullable = false)
    private String content;

    /**
     * Constructor vacio por defecto
     */
    public Note() {
    }

    /**
     * Constructor con el atributo principal de la clase note
     * @param id de la clase
     */
    public Note(String id) {
        this.id = id;
    }

    /**
     * Constructor con los atributos de la clase
     * @param id identificador de la nota
     * @param title titulo de la nota
     * @param content contenido de la nota
     */
    public Note(String id,String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
