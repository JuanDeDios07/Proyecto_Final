package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Docente;
import edu.ilp.sysgailp.entity.fichaMatricula;

import java.util.List;

public interface IFicha_MatriculaService {
    //lista de docentes
    List<fichaMatricula> ListaFichaMatricula2022();

    //lista de Docentes por Semestre
    List<fichaMatricula> listaFichas(String semestre);

    //este metodo regitra un nuevo Ficha de Matricula
    fichaMatricula guardarFicha(fichaMatricula fichaMatricula);

    //eliminar un ficha de matricula de la BD
    void eliminarFichaM(Long fichaM);

    //Listar Ficha-M semestre o matricula
    List<fichaMatricula> obtenerFichaPorSemestreMatricula(String apenom);
}
