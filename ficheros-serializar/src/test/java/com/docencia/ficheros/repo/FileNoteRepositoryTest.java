package com.docencia.ficheros.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.ficheros.model.Note;

class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    String id = "00001";
    String titulo = "mi titulo";
    String content = "contenido";
    Note elementofind = null;

    @BeforeEach
    void BeforeEach() {
        fileNoteRepository = new FileNoteRepository();
        elemento = new Note(id, titulo, content);
        elementofind = fileNoteRepository.find(elemento);
        Assertions.assertNull(elementofind, "El elemento debe ser nulo");
    }

    @AfterEach
    void AfterEach() {
        elementofind = fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementofind, "El elemento debe existir");
        fileNoteRepository.delete(id);
    }

    @Test
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no puede ser nulo");
    }

    @Test
    void insertNoteTest() {
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "El resultado no debe ser nulo");
        Assertions.assertEquals(result, result, "El valor no es el esperado");
    }
}
