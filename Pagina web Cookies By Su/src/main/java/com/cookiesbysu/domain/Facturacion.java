package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "facturacion")
public class Facturacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facturacion")
    private Long idFacturacion;

    private Long idUsuario;
    private int idOrden;
    private String direccionDetallada;
    private LocalDate fechaPedido;
    private LocalDate fechaEntrega;
    private String formaPago;
    private boolean cancelado;
    private boolean entregado;
    private double subtotal;
    private double iva;
    private double totalIva;
}
