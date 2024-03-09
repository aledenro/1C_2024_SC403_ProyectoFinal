package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, String> {
}
