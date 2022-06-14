package edu.ilp.sysgailp.dao;


import edu.ilp.sysgailp.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona,Long> {
    //Lista Persona por cargo
    @Query("SELECT e FROM Persona e WHERE e.cargo = :codigo")
    Persona ObtenerPersonaPorCodigo(@Param("codigo")String codigo);

    //listar Persona por nombre o apellido
    @Query("SELECT e FROM Persona e WHERE e.nombre LIKE CONCAT('%',:apenom,'%') OR e.apellido LIKE CONCAT('%',:apenom,'%') ")
    List<Persona> obtenerPersonaPorApellidoNOM(@Param("apenom") String apenom);
}
