package com.practica.sample.Repository;

import com.practica.sample.Entities.Estudiante;
import com.practica.sample.Entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository <Estudiante, String> {
    List<Estudiante> findByMateria(Materia materia);
}
