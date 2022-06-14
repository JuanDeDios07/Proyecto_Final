package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IDocenteDao;
import edu.ilp.sysgailp.entity.Docente;
import edu.ilp.sysgailp.service.IEDocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocenteServiceImpl implements IEDocenteServicio {

    @Autowired
    private IDocenteDao docenteDao;

    @Override
    public List<Docente> ListaDocente2022() {

        return this.docenteDao.findAll();
    }

    @Override
    public List<Docente> listaDocentes(String curso) {
        return this.docenteDao.findByCurso(curso);
    }

    @Override
    public Docente guardarDocente(Docente docente) {
        return this.docenteDao.save(docente);
    }

    @Override
    public void eliminarUnDocente(Long iddocente) {
        this.docenteDao.deleteById(iddocente);

    }

    @Override
    public List<Docente> obtenerDocentePorApellidoNOM(String apenom) {
        return this.docenteDao.obtenerDocentePorApellidoNOM(apenom);

    }


}
