package com.practica.sample.Services;

import com.practica.sample.Entities.Estudiante;
import com.practica.sample.Entities.Materia;

import java.util.List;

public interface EstudianteService {

    Estudiante createStudent(Estudiante estudiante);
    Estudiante updateStudent(Estudiante estudiante);
    List<Estudiante> getStudents();
    void deleteStudent(String cedula);
    Estudiante findStudent(String cedula);
    List<Materia> obtenerMaterias();  // Nuevo método para obtener las materias
    List<Estudiante> obtenerEstudiantesPorMateria(Integer idMateria); // Nuevo método para filtrar estudiantes
}
