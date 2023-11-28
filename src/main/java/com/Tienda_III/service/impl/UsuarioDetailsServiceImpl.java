/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_III.service.impl;

import com.Tienda_III.dao.UsuarioDao;
import com.Tienda_III.domain.Rol;
import com.Tienda_III.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_III.service.UsuarioDetailsService;

/**
 *
 * @author Vivian
 */
@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Buscar el usuario por el username en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);

        //si no existe el usuario lanza una exepcion 
        if (usuario == null) {
            throw new UsernameNotFoundException(username);

        }

        //Si llego aca es porque el usuario existe en la BD
        //Remover atributos de la session
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol item : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(item.getNombre()));

        }

        return new User(usuario.getUsername(), usuario.getPassword(), roles);

    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {

        return usuarioDao.findByUsername(username);
    }

}
