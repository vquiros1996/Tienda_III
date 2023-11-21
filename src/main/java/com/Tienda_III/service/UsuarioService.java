/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_III.service;

import com.Tienda_III.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Vivian
 */
public interface UsuarioService {
    
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    public Usuario getUsuarioPorUsername(String username);
    
    
}
