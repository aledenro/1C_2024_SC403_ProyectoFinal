package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombreProducto;
    private String descripcion;
    private String tipo;
    private double precio;
    private String rutaImagen;
}
