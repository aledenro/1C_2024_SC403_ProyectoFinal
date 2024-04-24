package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    private int idOrden;
    private int cantidad;
    private double total;
    private Long idProducto;

    public Pedido() {
    }

    public Pedido(int idOrden, int cantidad, double total, Long idProducto) {
        this.idOrden = idOrden;
        this.cantidad = cantidad;
        this.total = total;
        this.idProducto = idProducto;
    }
}
