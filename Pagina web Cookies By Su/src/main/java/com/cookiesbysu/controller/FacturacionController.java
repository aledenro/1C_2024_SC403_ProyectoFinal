package com.cookiesbysu.controller;

import com.cookiesbysu.domain.Facturacion;
import com.cookiesbysu.domain.Item;
import com.cookiesbysu.domain.Pedido;
import com.cookiesbysu.domain.Usuario;
import com.cookiesbysu.service.FacturacionService;
import com.cookiesbysu.service.ItemService;
import com.cookiesbysu.service.PedidoService;
import com.cookiesbysu.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/facturar")
public class FacturacionController {

    private double iva = 0;
    private double totalIva = 0;
    private double totalCarrito = 0;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private FacturacionService facturacionService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/verFacturacion")
    public String mostrarFactura(Model model) {
        iva = 0;
        totalIva = 0;
        totalCarrito = 0;

        var carrito = itemService.gets();
        var cantItems = carrito.size();

        for (Item i : carrito) {
            totalCarrito += (i.getCantidad() * i.getPrecio());
        }

        iva = totalCarrito * 0.13;
        totalIva = totalCarrito + iva;

        model.addAttribute("listado", carrito);
        model.addAttribute("cantItems", cantItems);
        model.addAttribute("totalCarrito", totalCarrito);
        model.addAttribute("iva", iva);
        model.addAttribute("totalIva", totalIva);
        model.addAttribute("facturacion", new Facturacion());

        return "/facturar/mostrar";
    }

    @PostMapping("/finalizar")
    public String facturar(@AuthenticationPrincipal UserDetails userDetails, Facturacion factura) {
        int idOrden = pedidoService.savePedido();
        Usuario u = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        LocalDate fechaPedido = LocalDate.now();
        factura.setIdOrden(idOrden);
        factura.setIdUsuario(u.getIdUsuario());
        factura.setSubtotal(totalCarrito);
        factura.setIva(iva);
        factura.setTotalIva(totalIva);
        factura.setFechaPedido(fechaPedido);

        facturacionService.savePedido(factura);

        return "/facturar/pedidoCompleto";
    }

    @GetMapping("/verPedidos")
    public String verPedidos(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Usuario u = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        boolean isAdmin = u.getRoles().contains("ROLE_ADMIN");
        List<Facturacion> listaPedidos = null;

        if (isAdmin) {
            listaPedidos = facturacionService.getAll();
        } else {
            listaPedidos = facturacionService.getPedidosByUser(u.getIdUsuario());
        }

        model.addAttribute("listadoPedidos", listaPedidos);

        return "/facturar/listado";
    }

    @GetMapping("/verPedido/{idFacturacion}")
    public String verPedido(Model model, Facturacion facturacion) {
        facturacion = facturacionService.getPedido(facturacion);
        var listaArticulos = pedidoService.findByOrden(facturacion.getIdOrden());

        model.addAttribute("listadoArticulos", listaArticulos);
        model.addAttribute("facturacion", facturacion);

        return "/facturar/pedido";
    }

}
