package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Producto;
import com.cookiesbysu.service.FirebaseStorageService;
import com.cookiesbysu.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("ver/{idProducto}")
    public String mostarProducto(Producto producto, Model model) {

        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        return "/producto/info";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardarProducto(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "productos", producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);

        }
        productoService.save(producto);

        return "redirect: /";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificaProducto(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        return "/producto/modifica";
    }

}
