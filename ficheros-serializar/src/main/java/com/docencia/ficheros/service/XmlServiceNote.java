package com.docencia.ficheros.service;

import java.util.List;

import com.docencia.ficheros.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlServiceNote implements IServiceNote {
    XmlMapper xmlMapper;

    public XmlServiceNote() {
        xmlMapper = new XmlMapper();
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
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
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
        String resultado = null;
        try {
            resultado = xmlMapper.writeValueAsString(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Note StringToNote(String data) {
        Note resultado = null;
        try {
            resultado = xmlMapper.readValue(data, Note.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
