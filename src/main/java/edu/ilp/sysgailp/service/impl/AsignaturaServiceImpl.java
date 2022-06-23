package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IAsignaturaDao;
import edu.ilp.sysgailp.entity.Asignatura;
import edu.ilp.sysgailp.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {
    @Autowired
    private IAsignaturaDao asignaturaDao;

    @Override
    public List<Asignatura> ListaAsignatura2022() {
        return this.asignaturaDao.findAll();
    }

    @Override
    public Asignatura obtenerAsignaturaPorCodigo(String codigo) {
        return this.asignaturaDao.ObtenerAsignaturaPorCodigo(codigo);
    }

    @Override
    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return this.asignaturaDao.save(asignatura);
    }

    @Override
    public void eliminarUnaAsignatura(Long idasignatura) {
        this.asignaturaDao.deleteById(idasignatura);
        //this.administrativoDao.deleteById(idadministrativo);
    }

    @Override
    public List<Asignatura> listarAsignatura() {
        return this.asignaturaDao.findAll();
    }
}
