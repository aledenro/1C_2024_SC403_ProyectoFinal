package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.UsuarioDao;
import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getUsername()).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    
}
