package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IAdministrativoDao;
import edu.ilp.sysgailp.entity.Administrativo;
import edu.ilp.sysgailp.entity.Escuela;
import edu.ilp.sysgailp.service.IAdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativoServiceImpl implements IAdministrativoService {
    @Autowired
    private IAdministrativoDao administrativoDao;

    @Override
    public List<Administrativo> ListaAdministrativo2022() {
        return this.administrativoDao.findAll();
    }

    @Override
    public Administrativo obtenerAdministrativoPorCodigo(String codigo) {
        return this.administrativoDao.ObtenerAdministrativoPorCodigo(codigo);
    }

    @Override
    public Administrativo guardarAdministrativo(Administrativo administrativo) {
        return this.administrativoDao.save(administrativo);
    }

    @Override
    public void eliminarUnadministrativo(Long idadministrativo) {
        this.administrativoDao.deleteById(idadministrativo);
    }

    @Override
    public List<Administrativo> obteneradministrativoPorApellidoNOM(String apenom) {
        return this.administrativoDao.obtenerAdministrativoPorApellidoNOM(apenom);
        //this.docenteDao.obtenerDocentePorApellidoNOM(apenom);
    }


}
