package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long idPerfil;

    private String username;
    private String cedula;
    private String nombre;
    private String apellidos;
    private String pais;
    private String provincia;
    private String cantonDistrito;
    private String direccionDetallada;
    private String correoElectronico;
    private String contrasena;
    private String numeroTelefono;
}
