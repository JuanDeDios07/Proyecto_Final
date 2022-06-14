package edu.ilp.sysgailp.dao;


import edu.ilp.sysgailp.entity.fichaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFicha_MatriculaDao extends JpaRepository<fichaMatricula,Long> {
  //Lista de ficha de matricula por semestre
    List<fichaMatricula> findBySemestre(String semestre);

  //Listar Ficha-M semestre o matricula
  @Query("SELECT e FROM fichaMatricula e WHERE e.semestre LIKE CONCAT('%',:apenom,'%') OR e.fmatricula LIKE CONCAT('%',:apenom,'%') ")
  List <fichaMatricula> obtenerFichaPorSemestreMatricula(@Param("apenom") String apenom);
}
