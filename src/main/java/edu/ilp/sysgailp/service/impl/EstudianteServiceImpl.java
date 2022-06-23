package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IEstudianteDao;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.entity.Estudiante;
import edu.ilp.sysgailp.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteDao estudianteDao;

    @Override
    public List<Estudiante> ListaEstudiantes() {
        return this.estudianteDao.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {

        return this.estudianteDao.save(estudiante);
    }

    @Override
    public List<Estudiante> listaEstudiante(Escuela idescuela) {

        return this.estudianteDao.findByEscuela(idescuela);
    }

    @Override
    public Page<Estudiante> listaEstudianteByPagina(Pageable pageable, Escuela idescuela) {
        return this.estudianteDao.listaEstudiante(pageable,idescuela);
    }

    @Override
    public void eliminarUnEstudiante(Long idestudiante) {

        this.estudianteDao.deleteById(idestudiante);
    }

    @Override
    public Estudiante obtenerEstudiante(String coddni) {

        return this.estudianteDao.obtenerEstudiante(coddni);
    }

    @Override
    public List<Estudiante> obtenerEstudiantePorApellidoNOM(String apenom) {
        return this.estudianteDao.obtenerEstudiantePorApellidoNOM(apenom);

    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return this.estudianteDao.findAll();
    }

    //@Override
    //public Estudiante obtenerEstudiantePorApellidoNOM(String apenom) {
        //return this.estudianteDao.obtenerEstudiantePorApellidoNOM(apenom);

}
