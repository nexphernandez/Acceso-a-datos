package com.docencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;

public abstract class ServiceNoteAbstracta implements IServiceNote {

    @Autowired
    INoteRepository notRepository;

    public INoteRepository getNotRepository() {
        return this.notRepository;
    }

    public void setNotRepository(INoteRepository notRepository) {
        this.notRepository = notRepository;
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}