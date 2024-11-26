package grupo3.spring.service;

import grupo3.spring.entities.Estudiante;

import java.util.List;

public interface EstudianteService {

    Estudiante crear(Estudiante estudiante);
    Estudiante modificar(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantes();
    void eliminar (String cedula);
    Estudiante buscarEstudiante(String cedula);
}
