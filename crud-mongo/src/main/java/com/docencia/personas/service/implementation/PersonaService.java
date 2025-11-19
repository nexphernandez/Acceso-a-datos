package com.docencia.personas.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;
import com.docencia.personas.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {

        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(String id) {
        // return personaRepository.findById(id);
        return null;
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean deleteById(String id) {
        personaRepository.deleteById(id);
        return true;
    }

}
