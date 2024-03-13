/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cookiesbysu.service;

import com.cookiesbysu.domain.Contacto;
import java.util.List;

/**
 *
 * @author valer
 */
public interface ContactoService {
        public List<Contacto> getContactos();

    public Contacto getContacto(Contacto contacto);

    public void save(Contacto contacto);

}
