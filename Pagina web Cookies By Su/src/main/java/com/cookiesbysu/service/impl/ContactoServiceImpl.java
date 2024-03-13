/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.ContactoDao;
import com.cookiesbysu.domain.Contacto;
import com.cookiesbysu.service.ContactoService;
import com.cookiesbysu.service.PersonalizadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author valer
 */

@Service
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDao contactoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getContactos() {
        var lista = contactoDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getCorreoElectronico()).orElse(null);
    }

    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

   
}
