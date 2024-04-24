package com.cookiesbysu.service;

import com.cookiesbysu.domain.Pedido;

import java.util.List;

public interface PedidoService {

    public int savePedido();

    public List<Pedido> findByOrden(int idOrden);
}
