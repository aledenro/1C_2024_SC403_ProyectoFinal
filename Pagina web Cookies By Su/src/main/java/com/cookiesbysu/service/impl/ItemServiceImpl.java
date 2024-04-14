package com.cookiesbysu.service.impl;

import com.cookiesbysu.domain.Item;
import com.cookiesbysu.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto().equals(item.getIdProducto())) {
                return i;
            }
        }

        return null;
    }

    @Override
    public void delete(Item item) {
        boolean existe = false;
        int posicion = 0;

        for (Item i : listaItems) {
            posicion++;
            if (i.getIdProducto().equals(item.getIdProducto())) {
                existe = true;
                break;
            }
        }

        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public void save(Item item) {
        boolean existe = false;

        for (Item i : listaItems) {
            if (i.getIdProducto().equals(item.getIdProducto())) {
                existe = true;
                i.setCantidad(i.getCantidad() + 1);
                break;
            }
        }

        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void update(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto().equals(item.getIdProducto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturarCarrito() {

    }
}
