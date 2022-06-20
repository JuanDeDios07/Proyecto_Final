package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Escuela;

import java.util.List;

public interface IEscuelaService {
    //Listar todas la sescuelas
    List<Escuela> listarEscuelas();

    //obtener escuela por su codigo
    Escuela obtenerEscuelaPorCodigo(String codigo);

    //Buscar una escuela a traves de su codigo y denominacion
    Escuela buscarEscuelaByIdAndDenominacion(Long idescuela,String denominacion);
    Escuela registraEscuela(Escuela escuela);
}
