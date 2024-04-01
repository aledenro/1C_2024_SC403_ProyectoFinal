package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.RolDao;
import com.cookiesbysu.dao.UsuarioDao;
import com.cookiesbysu.domain.Rol;
import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;

//    @Override
//    public Usuario getUsuario(Usuario usuario) {
//        return usuarioDao.findById(usuario.getUsername()).orElse(null);
//    }
    @Override
    public void saveUsuario(Usuario usuario, boolean crearUserRol) {
        usuario=usuarioDao.save(usuario);
        if (crearUserRol) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombreRol("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
                return usuarioDao.findByUsernameAndContrasena(username, password);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
                return usuarioDao.findByUsernameOrCorreoElectronico(username, correo);

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
                return usuarioDao.existsByUsernameOrCorreoElectronico(username, correo);

    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

}
