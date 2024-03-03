package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
}
