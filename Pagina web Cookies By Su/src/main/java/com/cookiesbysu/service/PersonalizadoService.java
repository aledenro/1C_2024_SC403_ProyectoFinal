package com.cookiesbysu.service;

import com.cookiesbysu.domain.Personalizado;
import jakarta.mail.MessagingException;

import java.util.List;
import org.springframework.ui.Model;

public interface PersonalizadoService {

    public List<Personalizado> getPedidosP();

    public Personalizado getPedidoP(Personalizado pedidoP);

    public void save(Personalizado pedidoP);

    public void delete(Personalizado pedidoP);

    public Model enviarCorreo(Model model, Personalizado pedidoP) throws MessagingException;

}
