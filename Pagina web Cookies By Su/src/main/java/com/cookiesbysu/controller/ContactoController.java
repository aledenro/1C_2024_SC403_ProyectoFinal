package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Contacto;
import com.cookiesbysu.service.ContactoService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author valer
 */
@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;


    @GetMapping("contactenos")
    public String contactenos(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "/contacto/form";
    }


    @PostMapping("/enviar")
    public String enviarCorreo(Model model, Contacto contacto)throws MessagingException {
        model=contactoService.enviarCorreo(model, contacto);
        return "/contacto/salida";
    }

}

