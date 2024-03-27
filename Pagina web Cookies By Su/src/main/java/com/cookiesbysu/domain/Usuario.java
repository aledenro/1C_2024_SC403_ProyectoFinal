package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @Column(name = "id_usuario")
    private Long idUsuario;


    /*
     *atributos Usuario
     */
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

    @OneToMany
    @JoinColumn(name = "id_usuario", updatable = false)
    private List<Rol> roles;
}
