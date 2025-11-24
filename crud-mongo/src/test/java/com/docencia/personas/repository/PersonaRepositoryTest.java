package com.docencia.personas.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {
    private Persona personafind;
    private PersonaRepository personaRepository;
    private Persona PersonaColection;
    private Direccion direccion;
    private String email = "un@gmail.com";
    private String ciudad = "Una ciudad";

    @Autowired
    public void setPersonaRepositoryTest(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBase(){
        personaRepository.deleteAll();
        direccion = new Direccion("Una calle", ciudad, "38200", "Canarias");
        PersonaColection = new Persona("test", 18, email, direccion);
        personafind = personaRepository.save(PersonaColection);
    }

    @Test
    void testFind(){
        Assertions.assertEquals(1, personaRepository.count()); 
        Assertions.assertNotNull(personafind);
        Assertions.assertNotNull(personafind.getId());
    }
    
    @Test
    void testFindByCiudad() {
        List<Persona> personas = personaRepository.findByCiudad(ciudad);
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getDireccion());
        Assertions.assertNotNull(persona.getDireccion().getCiudad());
        Assertions.assertEquals(persona.getDireccion().getCiudad(), ciudad);
    }

    @Test
    void testFindByEdadBetween() {
        List<Persona> personas = personaRepository.findByEdadBetween(10, 20);
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getEdad());
        Assertions.assertEquals(persona.getEdad(), 18);        
    }

    @Test
    void testFindByEmail() {
        Optional<Persona> personas = personaRepository.findByEmail(email);
        Assertions.assertNotNull(personas);
        Persona persona = personas.get();
        Assertions.assertNotNull(persona.getEmail());
        Assertions.assertEquals(persona.getEmail(), email);
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {
        List<Persona> personas = personaRepository.findByNombreContainingIgnoreCase("Test");
        Assertions.assertEquals(personas.size(), 1);
        Persona persona = personas.get(0);
        Assertions.assertNotNull(persona.getNombre());
        Assertions.assertEquals(personafind.getNombre(), persona.getNombre());

    }
}
