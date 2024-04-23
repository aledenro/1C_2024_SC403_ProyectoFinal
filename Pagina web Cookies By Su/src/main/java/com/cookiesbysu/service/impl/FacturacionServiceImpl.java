package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.FacturacionDao;
import com.cookiesbysu.domain.Facturacion;
import com.cookiesbysu.service.FacturacionService;

import static com.cookiesbysu.service.ItemService.listaItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturacionServiceImpl implements FacturacionService {

    @Autowired
    private FacturacionDao facturacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Facturacion> getAll() {
        return facturacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facturacion> getPedidosByUser(Long idUsuario) {
        return facturacionDao.findByIdUsuario(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Facturacion getPedido(Facturacion pedido) {
        return facturacionDao.findById(pedido.getIdFacturacion()).orElse(null);
    }

    @Override
    @Transactional
    public void savePedido(Facturacion pedido) {
        facturacionDao.save(pedido);
        listaItems.clear();
    }

    @Override
    @Transactional
    public void deletePedido(Facturacion pedido) {
        facturacionDao.delete(pedido);
    }
}
