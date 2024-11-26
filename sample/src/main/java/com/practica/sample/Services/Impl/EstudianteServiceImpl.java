package com.practica.sample.Services.Impl;

import com.practica.sample.Entities.Estudiante;
import com.practica.sample.Entities.Materia;
import com.practica.sample.Repository.EstudianteRepository;
import com.practica.sample.Repository.MateriaRepository;
import com.practica.sample.Services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public Estudiante createStudent(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateStudent(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> getStudents() {
        return estudianteRepository.findAll();
    }

    @Override
    public void deleteStudent(String cedula) {
        Estudiante estudiante = estudianteRepository.findById(cedula)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        estudianteRepository.delete(estudiante);
    }

    @Override
    public Estudiante findStudent(String cedula) {
        Estudiante estudiante = estudianteRepository.findById(cedula)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return estudiante;
    }

    @Override
    public List<Materia> obtenerMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorMateria(Integer idMateria) {
        Materia materia = materiaRepository.findById(idMateria)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return estudianteRepository.findByMateria(materia);
    }
}
