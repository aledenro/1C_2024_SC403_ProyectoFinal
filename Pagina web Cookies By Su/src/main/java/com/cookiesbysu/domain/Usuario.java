package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    private static final Long serialVersionUID = 1L;

    /*
     *PK Usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;

    /*
     *atributos Usuario
     */
    private String cedula;
    private String nombre;
    private String apellidos;
    private String pais;
    private String provincia;
    private String cantonDistrito;
    private String direccionDetallada;
    private String correoElectronico;
    private String contrasena;
    private String rol;
    private String numeroTelefono;
}
