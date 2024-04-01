package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Perfil;
import com.cookiesbysu.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("ver/{idPerfil}")
    public String mostarPerfil(Perfil perfil, Model model) {

        perfil = perfilService.getPerfil(perfil);
        model.addAttribute("perfil", perfil);

        return "/perfil/info";
    }


    @GetMapping("/modificar/{idPerfil}")
    public String modificaPerfil(Perfil perfil, Model model) {
        perfil = perfilService.getPerfil(perfil);
        model.addAttribute("perfil", perfil);

        return "/perfil/modifica";
    }

    @GetMapping("/agregar")
    public String agregaPerfil(Perfil perfil, Model model) {
        return "/perfil/agregarPerfil";
    }

    @GetMapping("eliminar/{idPerfil}")
    public String eliminaPerfil(Perfil perfil) {
        perfilService.delete(perfil);

        return "redirect:/";
    }

}
