package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturacionDao extends JpaRepository<Facturacion, Long> {

    public List<Facturacion> findByIdUsuario(Long idUsuario);
}
