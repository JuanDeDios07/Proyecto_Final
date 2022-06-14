package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Administrativo;
import edu.ilp.sysgailp.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAdministrativoDao extends JpaRepository<Administrativo,Long> {

    //Lista Administrativo por cargo
    //List<Administrativo> findByadministrativo(String AdminCodigo);
    @Query("SELECT e FROM Administrativo e WHERE e.cargo = :codigo")
    Administrativo ObtenerAdministrativoPorCodigo(@Param("codigo")String codigo);

    //listar Administrativo por nombre o apellido
    @Query("SELECT e FROM Administrativo e WHERE e.nombre LIKE CONCAT('%',:apenom,'%') OR e.apellido LIKE CONCAT('%',:apenom,'%') ")
    List <Administrativo> obtenerAdministrativoPorApellidoNOM(@Param("apenom") String apenom);

}
