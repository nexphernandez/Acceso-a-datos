package com.docencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.model.Note;
import com.docencia.repo.INotRepository;

public abstract class ServiceNoteAbstracta implements IServiceNote {

    @Autowired
    INotRepository notRepository;

    public INotRepository getNotRepository() {
        return this.notRepository;
    }

    public void setNotRepository(INotRepository notRepository) {
        this.notRepository = notRepository;
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}