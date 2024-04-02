package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("verPerfil")
    public String mostarPerfil(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        model.addAttribute("usuario", usuario);

        return "/perfil/infoPerfil";
    }

//    @GetMapping("eliminar/{idUsuario}")
//    public String eliminaPerfil(Usuario usuario) {
//        usuarioService.delete(usuario);
//
//        return "redirect:/";
//    }

    @PostMapping("/guardarUsuario")
    public String guardarUser(Usuario usuario) {

        usuarioService.actualizarDatos(usuario);

        return "redirect:/perfil/verPerfil";
    }

}
