package edu.ilp.sysgailp.service;

import edu.ilp.sysgailp.entity.Administrativo;
import edu.ilp.sysgailp.entity.Docente;
import edu.ilp.sysgailp.entity.Escuela;

import java.util.List;

public interface IAdministrativoService {
    //lista de Administrativo
    List<Administrativo> ListaAdministrativo2022();

    //lista de Administrativo por cargo
    //List<Administrativo> listaAdministrativos(String AdminCodigo);
    Administrativo obtenerAdministrativoPorCodigo(String codigo);

    //este metodo registra un nuevo administrativo
    Administrativo guardarAdministrativo(Administrativo administrativo);

    //eliminar un administrativo de la BD
    void eliminarUnadministrativo(Long idadministrativo);

    //Docente obteneradministrativoPorApellidoNOM(String apenom);
    List<Administrativo> obteneradministrativoPorApellidoNOM(String apenom);
}
