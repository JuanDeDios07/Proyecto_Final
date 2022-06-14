package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Asignatura;
import java.util.List;

public interface IAsignaturaService {

    //lista de Asignatura
    List<Asignatura> ListaAsignatura2022();

    //lista de Asignatura por denominacion
    Asignatura obtenerAsignaturaPorCodigo(String codigo);

    //este metodo registra un nuevo Asignatura
    Asignatura guardarAsignatura(Asignatura asignatura);

    //eliminar un Asignatura de la BD
    void eliminarUnaAsignatura(Long idasignatura);
}
