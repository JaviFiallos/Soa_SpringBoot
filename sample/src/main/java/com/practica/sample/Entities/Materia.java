package com.practica.sample.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateria;

    private String nombre;

    @OneToMany(mappedBy = "materia")
    private List<Estudiante> estudiantes;
}
