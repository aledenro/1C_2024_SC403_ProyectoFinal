/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.ContactoDao;
import com.cookiesbysu.domain.Contacto;
import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.ContactoService;
import com.cookiesbysu.service.CorreoService;
import jakarta.mail.MessagingException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 *
 * @author valer
 */
@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;
    @Autowired
    private CorreoService correoService;
    @Autowired
    private MessageSource messageSource;
//    @Autowired
//    private ContactoService contactoService;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getContactos() {
        var lista = contactoDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getCorreoElectronico()).orElse(null);
    }

    @Override
    public void enviar(Contacto contacto) {
            contactoDao.save(contacto);


    }

    @Override
    public Model enviarCorreo(Model model, Contacto contacto) 
            throws MessagingException {
        
        enviar(contacto);
        enviaCorreo(contacto);
        
        String mensaje = String.format(
                    messageSource.getMessage(
                        "contacto.enviado", 
                        null, 
                        Locale.getDefault()));
        
        model.addAttribute(
                "titulo", 
                messageSource.getMessage(
                        "contacto.enviado", 
                        null, 
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje", mensaje);
                
        return model;
    }

    @Value("${servidor.http}")
    private String servidor;

    private void enviaCorreo(Contacto contacto) throws MessagingException {
        String mensaje = messageSource.getMessage(
                "contacto.correo.mensaje",
                null, Locale.getDefault());
        mensaje = String.format(
                mensaje, contacto.getNombre(),
                contacto.getApellidos(), servidor,
                contacto.getCorreoElectronico());
        String asunto = messageSource.getMessage(
                "contacto.correo.asunto",
                null, Locale.getDefault());
        correoService.enviarCorreoHtml(contacto.getCorreoElectronico(), asunto, mensaje);
    }

}
