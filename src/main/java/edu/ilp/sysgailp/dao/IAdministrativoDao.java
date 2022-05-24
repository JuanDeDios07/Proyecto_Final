package edu.ilp.sysgailp.dao;

import edu.ilp.sysgailp.entity.Administrativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdministrativoDao extends JpaRepository<Administrativo,Long> {
}
