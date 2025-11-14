package com.docencia.objetos.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;

public class AlumnoMapperUtils {

    /**
     * Funcion que transforma un objeto de tipo AlumnoEntity a Alumno
     * @param alumnoEntity alumno a transformar
     * @return alumno transformado
     */
    public static Alumno to(AlumnoEntity alumnoEntity){
        if (alumnoEntity == null) {
            return null;
        }
        return new Alumno(alumnoEntity.getId(), alumnoEntity.getNombre(), alumnoEntity.getEmail(), alumnoEntity.getCiclo());
        
    }

    /**
     * Funcion que transforma un objeto de tipo AlumnoEntity a Alumno
     * @param alumnoEntity alumno a transformar
     * @return alumno transformado
     */
    public static AlumnoEntity to(Alumno alumno){
        if (alumno == null) {
            return null;
        }
        return new AlumnoEntity(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
    }

    /**
     * Funcion que trasforma todos los objetos de la lista de tipo
     * AlumnoEntity a Alumno
     * @param alumnosEntity lista de alumnos a transformar
     * @return Lista de alumnos transformado
     */
    public static List<Alumno> to(List<AlumnoEntity> alumnosEntity){
        List<Alumno> alumnos = new ArrayList<>();
        if (alumnosEntity.isEmpty() || alumnosEntity == null) {
            return alumnos;
        }
        for (AlumnoEntity alumnoEntity: alumnosEntity) {
            alumnos.add(to(alumnoEntity));
        }
        return alumnos;
    }

    /**
     * Funcion que trasforma todos los objetos de la lista de tipo
     * AlumnoEntity a Alumno
     * @param alumnosEntity lista de alumnos a transformar
     * @return Lista de alumnos transformado
     */
    public static Optional<Alumno> to(Optional<AlumnoEntity> alumnosEntity) {
        Optional<Alumno> valor = java.util.Optional.empty();
        if (alumnosEntity.isEmpty() || alumnosEntity  == null) {
            return valor;
        }
        return valor.map(alumno -> to(alumnosEntity).orElse(null));
    }

}
