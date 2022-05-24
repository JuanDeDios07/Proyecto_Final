package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IEstudianteService {

    //este metodo regitra un nuevo estudiante
    Estudiante guardarEstudiante(Estudiante estudiante);

    //lista de estudiantes por escuela
    List<Estudiante> listaEstudiante(Escuela idescuela);

    //lista estudiante por escuela por pagina
    Page<Estudiante> listaEstudianteByPagina(Pageable pageable, Escuela idescuela);

    //eliminar un estudiante de la BD
    void eliminarUnEstudiante(Long idestudiante);

    //obtener estudiante atraves de su codigo o dni
    Estudiante obtenerEstudiante(String coddni );

    //obtener estudiantemediante su nombreo apellido

    //Estudiante obtenerEstudiantePorApellidoNOM(String apenom);
    List<Estudiante> obtenerEstudiantePorApellidoNOM(String apenom);

    //actualisaR registro de estudiantes



}
