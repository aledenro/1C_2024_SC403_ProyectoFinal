package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Personalizado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalizadoDao extends JpaRepository<Personalizado, Long> {
}