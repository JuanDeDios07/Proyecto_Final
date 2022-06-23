package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IFicha_MatriculaDao;
import edu.ilp.sysgailp.entity.fichaMatricula;
import edu.ilp.sysgailp.service.IFicha_MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ficha_MatriculaServiceImpl implements IFicha_MatriculaService {
    @Autowired
    private IFicha_MatriculaDao fichaMatricula;

    @Override
    public List<edu.ilp.sysgailp.entity.fichaMatricula> ListaFichaMatricula2022() {
        return this.fichaMatricula.findAll();
    }

    @Override
    public List<edu.ilp.sysgailp.entity.fichaMatricula> listaFichas(String semestre) {
        return this.fichaMatricula.findBySemestre(semestre);
        //this.docenteDao.findByCurso(curso);
    }

    @Override
    public edu.ilp.sysgailp.entity.fichaMatricula guardarFicha(fichaMatricula fichaMatricula) {
        return this.fichaMatricula.save(fichaMatricula);
        //return this.docenteDao.save(docente);
    }

    @Override
    public void eliminarFichaM(Long fichaM) {
        this.fichaMatricula.deleteById(fichaM);
        //this.docenteDao.deleteById(iddocente);
    }

    @Override
    public List<edu.ilp.sysgailp.entity.fichaMatricula> obtenerFichaPorSemestreMatricula(String apenom) {
        return this.fichaMatricula.obtenerFichaPorSemestreMatricula(apenom);
    }

    @Override
    public List<edu.ilp.sysgailp.entity.fichaMatricula> listarFichaMatricula01() {
        return this.fichaMatricula.findAll();
    }
}
