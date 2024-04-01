package com.cookiesbysu.service.impl;

import com.cookiesbysu.dao.PerfilDao;
import com.cookiesbysu.domain.Perfil;
import com.cookiesbysu.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilDao perfilDao;

    /**
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Perfil> getPerfil() {
        var listaPerfil = perfilDao.findAll();

        return listaPerfil;
    }

    @Override
    @Transactional(readOnly = true)
    public Perfil getPerfil(Perfil perfil) {
        return perfilDao.findById(perfil.getIdPerfil()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Perfil perfil) {
        perfilDao.save(perfil);
    }

    @Override
    @Transactional
    public void delete(Perfil perfil) {
        perfilDao.delete(perfil);
    }

}
