package com.docencia.repo;

import java.util.List;


import com.docencia.model.Note;

public interface INotRepository {
    public boolean exists(String id);

    public Note findById(String id);

    public Note find(Note note);

    public List<Note> findAll();

    public Note save(Note n);

    public boolean delete(String id);
}
