package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IAsignaturaDao extends JpaRepository<Asignatura,Long> {

    //Lista Asignatura por denominacion
    @Query("SELECT e FROM Asignatura e WHERE e.denominacion = :codigo")
    Asignatura ObtenerAsignaturaPorCodigo(@Param("codigo")String codigo);

}
