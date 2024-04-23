package com.cookiesbysu.service;

import com.cookiesbysu.domain.Facturacion;
import com.cookiesbysu.domain.Pedido;

import java.util.List;

public interface FacturacionService {

    public List<Facturacion> getAll();

    public List<Facturacion> getPedidosByUser(Long idUsuario);

    Facturacion getPedido(Facturacion pedido);

    void savePedido(Facturacion pedido);

    void deletePedido(Facturacion pedido);
}
