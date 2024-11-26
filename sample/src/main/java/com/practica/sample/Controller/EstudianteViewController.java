package com.practica.sample.Controller;

import com.practica.sample.Entities.Estudiante;
import com.practica.sample.Services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteViewController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String listarEstudiantes(@RequestParam(required = false) Integer idMateria, Model model) {
        List<Estudiante> estudiantes;
        if (idMateria != null) {
            estudiantes = estudianteService.obtenerEstudiantesPorMateria(idMateria);
        } else {
            estudiantes = estudianteService.getStudents();
        }
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("materias", estudianteService.obtenerMaterias()); // Pasamos las materias al modelo
        return "lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("materias", estudianteService.obtenerMaterias()); // También cargamos las materias en el formulario
        return "formulario";
    }

    @PostMapping("/guardar")
    public String saveStudent(Estudiante estudiante){
        estudianteService.createStudent(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{cedula}")
    public String mostrarFormularioEditar(@PathVariable String cedula, Model model) {
        Estudiante estudiante = estudianteService.findStudent(cedula);
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("materias", estudianteService.obtenerMaterias()); // Cargamos las materias
        return "formulario";
    }

    @GetMapping("/eliminar/{cedula}")
    public String deleteStudent(@PathVariable String cedula){
        estudianteService.deleteStudent(cedula);
        return "redirect:/estudiantes";
    }


    @GetMapping("/buscar")
    public String buscarEstudiante(@RequestParam(required = false) String cedula, Model model) {
        if (cedula == null || cedula.trim().isEmpty()) {
            model.addAttribute("estudiantes", estudianteService.getStudents());
        } else {
            Estudiante estudiante = estudianteService.findStudent(cedula);
            if (estudiante != null) {
                model.addAttribute("estudiantes", List.of(estudiante));
            } else {
                model.addAttribute("estudiantes", List.of());
                model.addAttribute("mensajeError", "No se encontró ningún estudiante con la cédula");
            }
        }
        return "lista";
    }

}
