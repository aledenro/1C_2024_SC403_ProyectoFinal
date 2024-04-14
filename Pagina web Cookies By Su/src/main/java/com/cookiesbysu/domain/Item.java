package com.cookiesbysu.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto {
    private int cantidad;

    public Item(Producto p) {
        super.setNombreProducto(p.getNombreProducto());
        super.setRutaImagen(p.getRutaImagen());
        super.setDescripcion(p.getDescripcion());
        super.setTipo(p.getTipo());
        super.setPrecio(p.getPrecio());
        super.setIdProducto(p.getIdProducto());
        this.cantidad = 0;
    }
}
