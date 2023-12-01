/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_III.dao;
import com.Tienda_III.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Vivian
 */

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}

