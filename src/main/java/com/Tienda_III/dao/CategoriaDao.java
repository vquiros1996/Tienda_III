/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_III.dao;

import com.Tienda_III.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vivian
 */
//Se hace import de la clase Categoria de java, porque estan en diferentes paquetes
//el segundo valor es el tio de dato del ID que es tipo de dato LONG
public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
    List<Categoria> findByDescripcionContainingIgnoreCase(String descripcion);
    
    
    
    

}
