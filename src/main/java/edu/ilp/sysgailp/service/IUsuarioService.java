package edu.ilp.sysgailp.service;


import edu.ilp.sysgailp.entity.Usuario;

public interface IUsuarioService {

    Usuario getPersonaByUsuario(String username);
}
