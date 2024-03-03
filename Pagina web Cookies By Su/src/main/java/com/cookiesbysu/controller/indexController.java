package com.cookiesbysu.controller;

import com.cookiesbysu.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String listadoProductos(Model model) {

        var listaProductos = productoService.getProductos();
        model.addAttribute("productos", listaProductos);

        return "index";
    }
}
