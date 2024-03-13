package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao extends JpaRepository<Contacto, String> {
}
