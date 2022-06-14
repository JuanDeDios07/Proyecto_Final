package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IDocenteDao extends JpaRepository<Docente,Long> {

    //Lista docentes por curso
    List<Docente> findByCurso(String curso);

    //listar docente por nombre o apellido
    @Query("SELECT e FROM Docente e WHERE e.nombre LIKE CONCAT('%',:apenom,'%') OR e.apellido LIKE CONCAT('%',:apenom,'%') ")
    List <Docente> obtenerDocentePorApellidoNOM(@Param("apenom") String apenom);
}
