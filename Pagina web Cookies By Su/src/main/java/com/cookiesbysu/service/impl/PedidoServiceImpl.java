package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.PedidoDao;
import com.cookiesbysu.dao.ProductoDao;
import com.cookiesbysu.domain.Item;
import com.cookiesbysu.domain.Pedido;
import com.cookiesbysu.domain.Producto;
import com.cookiesbysu.service.PedidoService;
import com.cookiesbysu.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> findByOrden(int idOrden) {
        var listaPeds = pedidoDao.findByIdOrden(idOrden);
        List<Producto> listaProds = new ArrayList<>();

        for (Pedido ped : listaPeds) {
            var p = productoDao.findById(ped.getIdProducto()).orElse(null);
            listaProds.add(p);
        }

        return listaProds;
    }
}
