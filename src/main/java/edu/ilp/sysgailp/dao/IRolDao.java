package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDao extends JpaRepository<Rol,Long> {

    Rol findByNombrerol(String roleName);

    @Query("SELECT r FROM Rol r WHERE r.idrol = :idrol")
    Rol findByIdrol(@Param("idrol") Long idrol);
}
