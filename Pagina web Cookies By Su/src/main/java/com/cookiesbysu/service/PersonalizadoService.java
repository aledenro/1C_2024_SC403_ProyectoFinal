package com.cookiesbysu.service;

import com.cookiesbysu.domain.Personalizado;

import java.util.List;

public interface PersonalizadoService {

    public List<Personalizado> getPedidoP();

    public Personalizado getPedidoP(Personalizado pedidoP);

    public void save(Personalizado pedidoP);

    public void delete(Personalizado pedidoP);
}
