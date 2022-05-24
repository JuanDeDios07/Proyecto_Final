package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.Estudiante;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteDao extends JpaRepository<Estudiante,Long> {
    //Lista estudiantes por escuela
    List<Estudiante> findByEscuela(Escuela idescuela);

    //Liata estudiante de una escuela por paginas

    @Query("SELECT e FROM Estudiante e WHERE e.escuela = :idescuela")
    Page<Estudiante> listaEstudiante(Pageable pageable, @Param("idescuela")Escuela idescuela);

    //obtener estudiante por dni o codiga
    @Query("SELECT e FROM Estudiante e WHERE e.codigo = :coddni OR e.dni = :coddni")
    Estudiante obtenerEstudiante(@Param("coddni") String coddni);

    //obtener estudiantemediante su nombreo apellido

   // @Query("SELECT e FROM Estudiante e WHERE e.apellido = :apenom OR e.nombre = :apenom")
  // Estudiante obtenerEstudiantePorApellidoNOM(@Param("apenom") String apenom);
   @Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE CONCAT('%',:apenom,'%') OR e.apellido LIKE CONCAT('%',:apenom,'%') ")
    List <Estudiante> obtenerEstudiantePorApellidoNOM(@Param("apenom") String apenom);

}
