package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IEscuelaDao;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.service.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EscuelaServiceImpl implements IEscuelaService {

    @Autowired
    private IEscuelaDao escuelaDao;
    @Override
    public List<Escuela> listarEscuelas() {
        return this.escuelaDao.findAll();
    }

    @Override
    public Escuela obtenerEscuelaPorCodigo(String codigo) {
        return this.escuelaDao.obtenerEscuelaPorParam(codigo);
    }

    @Override
    public Escuela buscarEscuelaByIdAndDenominacion(Long idescuela, String nombre) {
        return this.escuelaDao.findByIdescuelaAndDenominacion(idescuela,nombre);
    }

    @Override
    public Escuela registraEscuela(Escuela escuela) {
        return this.escuelaDao.save(escuela);
    }

}
