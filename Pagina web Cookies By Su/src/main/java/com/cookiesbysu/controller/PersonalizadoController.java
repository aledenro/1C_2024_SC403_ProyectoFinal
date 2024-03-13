package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Personalizado;
import com.cookiesbysu.service.PersonalizadoService;
import com.cookiesbysu.service.impl.FirebaseStorageServiceImpl;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author valer
 */
@Controller
@RequestMapping("/personalizado")
public class PersonalizadoController {

    @Autowired
    private PersonalizadoService personalizadoService;


    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @GetMapping("verForm")
    public String verForm(Model model) {
        model.addAttribute("pedidoP", new Personalizado());
        return "/personalizado/form";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("pedidoP") Personalizado pedidoP,
                          @RequestParam("imagenFile") MultipartFile imagenFile,
                          @RequestParam("fechaPreliminar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        if (!imagenFile.isEmpty()) {
            // si no esta vacio se debe subir la imagen
            personalizadoService.save(pedidoP);
            String rutaImagen = firebaseStorageServiceImpl.cargaImagen(imagenFile, "pedidoPersonalizado", pedidoP.getIdPedidoP());
            pedidoP.setRutaImagen(rutaImagen);

        }
        pedidoP.setFechaPreliminar(fecha);
        personalizadoService.save(pedidoP);
        return "redirect:/";
    }
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = personalizadoService.getPedidosP();
        model.addAttribute("pedidosP", lista);
        model.addAttribute("totalPedidoP", lista.size());


        return "/personalizado/listado";
    }

    
    @GetMapping("/eliminar/{idPedidoP}")
    public String eliminar(Personalizado pedidoP) {
        personalizadoService.delete(pedidoP);
        return "redirect:/personalizado/listado";
    }
    
}

