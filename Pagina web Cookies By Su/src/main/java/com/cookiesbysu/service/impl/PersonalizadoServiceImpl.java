package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.PersonalizadoDao;
import com.cookiesbysu.domain.Personalizado;
import com.cookiesbysu.service.PersonalizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalizadoServiceImpl implements PersonalizadoService {

    @Autowired
    private PersonalizadoDao personalizadoDao;
    
    @Override
    public List<Personalizado> getPedidoP() {
        var listaPersonalizados = personalizadoDao.findAll();

        return listaPersonalizados;
    }


    @Override
    @Transactional
    public void save(Personalizado pedidoP) {
        personalizadoDao.save(pedidoP);
    }

    @Override
    @Transactional
    public void delete(Personalizado pedidoP) {
        personalizadoDao.delete(pedidoP);
    }


    @Override
    @Transactional(readOnly = true)
    public Personalizado getPedidoP(Personalizado pedidoP) {
        return personalizadoDao.findById(pedidoP.getIdPedidoP()).orElse(null);
    }

}
