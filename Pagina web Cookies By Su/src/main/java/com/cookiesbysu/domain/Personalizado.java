package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pedido_personalizado")
public class Personalizado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidop")
    private Long idPedidoP;

    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private int numeroTelefono;
    private LocalDate fechaPreliminar;
    private String descripcion;
    private String rutaImagen;
}

