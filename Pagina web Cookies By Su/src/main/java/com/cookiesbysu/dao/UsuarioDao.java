package com.cookiesbysu.dao;

import com.cookiesbysu.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    public Usuario findByUsernameAndContrasena(String username, String contrasena);

    public Usuario findByUsernameOrCorreoElectronico(String username, String correo);

    public boolean existsByUsernameOrCorreoElectronico(String username, String correo);

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre = :nombre, u.apellidos = :apellidos, u.pais = :pais, u.provincia = :provincia, u.cantonDistrito = :cantonDistrito, " +
            "u.direccionDetallada = :direccionDetallada, u.numeroTelefono = :numeroTelefono WHERE u.idUsuario = :idUsuario")
    public void updateDatosUsuario(@Param(value = "idUsuario") Long idUsuario, @Param(value = "nombre") String nombre, @Param(value = "apellidos") String apellidos,
                                   @Param(value = "pais") String pais, @Param(value = "provincia") String provincia, @Param(value = "cantonDistrito") String cantonDistrito,
                                   @Param(value = "direccionDetallada") String direccionDetallada, @Param(value = "numeroTelefono") String numeroTelefono);

}



