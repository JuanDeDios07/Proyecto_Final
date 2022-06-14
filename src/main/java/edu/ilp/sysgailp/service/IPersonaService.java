package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Persona;

import java.util.List;

public interface IPersonaService {
    //lista de Persona
    List<Persona> ListaPersona2022();

    //lista de Persona por cargo
    Persona obtenerPersonaPorCodigo(String codigo);

    //este metodo registra un nuevo Persona
    Persona guardarPersona(Persona persona);

    //eliminar un Persona de la BD
    void eliminarUnaPersona(Long idpersona);

    //Docente obtenerPersonaPorApellidoNOM(String apenom);
    List<Persona> obtenerPersonaPorApellidoNOM(String apenom);
}
