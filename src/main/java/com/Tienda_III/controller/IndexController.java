/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_III.controller;

import com.Tienda_III.domain.Item;
import com.Tienda_III.domain.Producto;
import com.Tienda_III.service.ItemService;
import com.Tienda_III.service.ProductoService;
import com.Tienda_III.controller.CarritoController;
import com.Tienda_III.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vivian
 */
@Controller
public class IndexController {

    @Autowired
    ProductoService productoService;
    //ruta base para poder acceder via  web el request mapping 

    @Autowired
    private ItemService itemService;
    
    
    @RequestMapping("/")
    public String page(Model model) {
        var listaProductos = productoService.getProductos(true);
        model.addAttribute("productos", listaProductos);
        //busca las vistas a partir del return
        return "index";
    }

    @RequestMapping("/refrescarBoton")
    public ModelAndView refrescarBoton(Model model) {
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }

        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    
}
    
}
