package com.docencia.ficheros.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.ficheros.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstracta {
    JsonMapper jsonMapper;

    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    public JsonServiceNote() {
        jsonMapper = new JsonMapper();
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Note save(Note n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        try {
            return jsonMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformacion de note {}",
                    note, e);
        }
        return null;
    }

    @Override
    public Note StringToNote(String data) {
        Note resultado = null;
        try {
            resultado = jsonMapper.readValue(data, Note.class);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformacion de data {}",
                    data, e);
        }
        return resultado;
    }
}
