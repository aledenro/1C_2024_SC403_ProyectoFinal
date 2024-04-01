package com.cookiesbysu.service;

import com.cookiesbysu.domain.Perfil;

import java.util.List;

public interface PerfilService {

    public List<Perfil> getPerfil();

    public Perfil getPerfil(Perfil perfil);

    public void save(Perfil perfil);

    public void delete(Perfil perfil);
}
