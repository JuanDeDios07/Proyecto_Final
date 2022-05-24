package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEscuelaDao extends JpaRepository<Escuela,Long> {
    Escuela findByCodigoEscuela(String codigo);

    @Query("SELECT e FROM Escuela e WHERE e.codigoEscuela =?1")
    Escuela ObtenerEcuelaPorCodigo(String codigo);

    @Query("SELECT e FROM Escuela e WHERE e.codigoEscuela = :codigo")
    Escuela obtenerEscuelaPorParam(@Param("codigo")String codigo);


    //obtener una escuela atraves de su id y denominacon
    Escuela findByIdescuelaAndDenominacion(Long idescuela , String denominacion);
}
