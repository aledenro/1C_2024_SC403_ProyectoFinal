/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cookiesbysu.service;

import com.cookiesbysu.domain.Contacto;
import jakarta.mail.MessagingException;
import java.util.List;
import org.springframework.ui.Model;

/**
 *
 * @author valer
 */
public interface ContactoService {

    public List<Contacto> getContactos();

    public Contacto getContacto(Contacto contacto);

    public void enviar(Contacto contacto);
    
    public Model enviarCorreo(Model model, Contacto contacto) throws MessagingException;

}
