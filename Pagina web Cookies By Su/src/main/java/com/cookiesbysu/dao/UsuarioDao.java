package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    public Usuario findByUsernameAndContrasena(String username, String contrasena);

    public Usuario findByUsernameOrCorreoElectronico(String username, String correo);

    public boolean existsByUsernameOrCorreoElectronico(String username, String correo);

}
