package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
    @Query(nativeQuery = true, value = "SELECT MAX(id_orden) FROM pedido")
    public Integer selectMaxOrder();
}
