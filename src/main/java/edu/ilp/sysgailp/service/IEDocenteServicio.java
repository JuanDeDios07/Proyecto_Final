package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Docente;

import java.util.List;

public interface IEDocenteServicio {

    //lista de docentes
    List<Docente> ListaDocente2022();

    //lista de Docentes por curso
    List<Docente> listaDocentes(String curso);

    //este metodo regitra un nuevo docente
    Docente guardarDocente(Docente docente);

    //eliminar un docente de la BD
    void eliminarUnDocente(Long iddocente);

    //Docente obtenerDocentePorApellidoNOM(String apenom);
    List<Docente> obtenerDocentePorApellidoNOM(String apenom);
}
