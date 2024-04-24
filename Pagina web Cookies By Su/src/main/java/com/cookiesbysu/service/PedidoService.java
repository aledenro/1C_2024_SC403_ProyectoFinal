package com.cookiesbysu.service;

import com.cookiesbysu.domain.Pedido;
import com.cookiesbysu.domain.Producto;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    public int savePedido();

    public List<Producto> findByOrden(int idOrden);
}
