package com.cookiesbysu.service;


import jakarta.mail.MessagingException;

/**
 *
 * @author valer
 */
public interface CorreoService {

    //firma del metodo para enviar correos html
    public void enviarCorreoHtml(String para, String asunto, String contenidoHtml) throws MessagingException;
}
