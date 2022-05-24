package edu.ilp.sysgailp.service.impl;

import edu.ilp.sysgailp.dao.IUsuarioDao;
import edu.ilp.sysgailp.entity.Usuario;
import edu.ilp.sysgailp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario getPersonaByUsuario(String username) {
        System.out.println("ESTOY EN EL METODO SERVICE USER >>> ");
        Usuario user = this.usuarioDao.findPersonaByUsername(username);

        System.out.println("ID EXTRAIDO DEL USUARIO >>>> " + user.getPersona());

        return user;
    }
}
