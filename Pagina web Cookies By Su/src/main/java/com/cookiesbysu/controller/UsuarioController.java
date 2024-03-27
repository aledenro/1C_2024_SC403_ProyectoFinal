package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//    @GetMapping("/verPerfil/{username}")
//    public String mostrarPerfilUsuario(Usuario usuario, Model model) {
//
//        usuario = usuarioService.getUsuario(usuario);
//        model.addAttribute("usuario", usuario);
//
//        return "/usuario/perfil";
//    }
//
//    @GetMapping("/irRegistro")
//    public String registro(Usuario usuario, Model model) {
//        return "/usuario/registro";
//    }

//    @PostMapping("/guardarUsuario")
//    public String guardarUser(Usuario usuario) {
//
//        Usuario checkUsuario = usuarioService.getUsuario(usuario);
//
//        if (checkUsuario != null) {
//
//        }
//
//        usuario.setRol("Cliente");
//
//        usuarioService.saveUsuario(usuario);
//
//        return "redirect:/";
//    }
}
