package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.PedidoDao;
import com.cookiesbysu.domain.Item;
import com.cookiesbysu.domain.Pedido;
import com.cookiesbysu.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.cookiesbysu.service.ItemService.listaItems;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    @Transactional
    public int savePedido() {
        Integer numOrden = pedidoDao.selectMaxOrder();

        if (numOrden == null) {
            numOrden = 0;
        }

        numOrden += 1;

        for (Item i : listaItems) {
            Pedido pedido = new Pedido(numOrden, i.getCantidad(), (i.getCantidad() * i.getPrecio()), i.getIdProducto());
            pedidoDao.save(pedido);
        }

        return numOrden;
    }
}
