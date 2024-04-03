package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.PersonalizadoDao;
import com.cookiesbysu.domain.Personalizado;
import com.cookiesbysu.service.CorreoService;
import com.cookiesbysu.service.PersonalizadoService;
import jakarta.mail.MessagingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

@Service
public class PersonalizadoServiceImpl implements PersonalizadoService {

    @Autowired
    private PersonalizadoDao personalizadoDao;
    @Autowired
    private CorreoService correoService;
    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional(readOnly = true)
    public List<Personalizado> getPedidosP() {
        var listaPersonalizados = personalizadoDao.findAll();

        return listaPersonalizados;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Personalizado getPedidoP(Personalizado pedidoP) {
        return personalizadoDao.findById(pedidoP.getIdPedidoP()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Personalizado pedidoP) {
        personalizadoDao.save(pedidoP);
    }

    @Override
    @Transactional
    public void delete(Personalizado pedidoP) {
        personalizadoDao.delete(pedidoP);
    }

    @Override
    public Model enviarCorreo(Model model, Personalizado pedidoP) 
            throws MessagingException {
        
        save(pedidoP);
        enviaCorreo(pedidoP);
        
        String mensaje = String.format(
                    messageSource.getMessage(
                        "personalizado.enviado", 
                        null, 
                        Locale.getDefault()));
        
        model.addAttribute(
                "titulo", 
                messageSource.getMessage(
                        "personalizado.enviado", 
                        null, 
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje", mensaje);
                
        return model;
    }

    @Value("${servidor.http}")
    private String servidor;

    private void enviaCorreo(Personalizado pedidoP) throws MessagingException {
        String mensaje = messageSource.getMessage(
                "personalizado.correo.mensaje",
                null, Locale.getDefault());
        mensaje = String.format(
                mensaje, pedidoP.getNombre(),
                pedidoP.getApellidos(), servidor,
                pedidoP.getCorreoElectronico());
        String asunto = messageSource.getMessage(
                "personalizado.correo.asunto",
                null, Locale.getDefault());
        correoService.enviarCorreoHtml(pedidoP.getCorreoElectronico(), asunto, mensaje);
    }
    

    

}
