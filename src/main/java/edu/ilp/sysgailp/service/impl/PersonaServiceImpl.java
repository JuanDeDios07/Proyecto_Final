package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IPersonaDao;
import edu.ilp.sysgailp.entity.Persona;
import edu.ilp.sysgailp.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaDao personaDao;
    @Override
    public List<Persona> ListaPersona2022() {
        return this.personaDao.findAll();
    }

    @Override
    public Persona obtenerPersonaPorCodigo(String codigo) {
        return this.personaDao.ObtenerPersonaPorCodigo(codigo);
        //this.administrativoDao.ObtenerAdministrativoPorCodigo(codigo);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return this.personaDao.save(persona);
    }

    @Override
    public void eliminarUnaPersona(Long idpersona) {
        this.personaDao.deleteById(idpersona);
    }

    @Override
    public List<Persona> obtenerPersonaPorApellidoNOM(String apenom) {
        return this.personaDao.obtenerPersonaPorApellidoNOM(apenom);

    }
}
