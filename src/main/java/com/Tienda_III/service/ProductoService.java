/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_III.service;

import com.Tienda_III.domain.Producto;
import java.util.List;

/**
 *
 * @author Vivian
 */
public interface ProductoService {

    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);
// Se obtiene un Producto, a partir del id de un producto

    public Producto getProducto(Producto producto);
// Se inserta un nuevo producto si el id del producto esta vaci
// Se actualiza un producto si el id del producto NO esta vacio

    public void save(Producto producto);
// Se elimina el producto que tiene el id pasado por parametro

    public void delete(Producto producto);

}
