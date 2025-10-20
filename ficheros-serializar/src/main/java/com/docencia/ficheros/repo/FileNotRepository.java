package com.docencia.ficheros.repo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.docencia.ficheros.model.Note;

public class FileNotRepository implements INotRepository {

    private String nameFile;

    public FileNotRepository() {
        this.nameFile = "note-repository.txt";
        try {
            verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void verificarFichero() throws IOException {
        URL resource;
        resource = getClass().getClassLoader().getResource(nameFile);
        if (resource == null) {
            throw new IOException("El fichero no exisite " + nameFile);
        }
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

}
