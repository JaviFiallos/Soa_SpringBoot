package com.practica.sample.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="estudiantes")
@Data
public class Estudiante {

    @Id
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;
}
