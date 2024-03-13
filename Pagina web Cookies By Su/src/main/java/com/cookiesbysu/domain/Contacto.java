/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cookiesbysu.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author valer
 */

@Data
@Entity
@Table(name = "form_contacto")
public class Contacto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private int idRequest;
    private String correoElectronico;
    private String nombre;
    private String apellidos;
    private String mensaje;
}
