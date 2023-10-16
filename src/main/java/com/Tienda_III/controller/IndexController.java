/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_III.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vivian
 */
@Controller
public class IndexController {
   
    //ruta base para poder acceder via  web el request mapping 
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
       
        //busca las vistas a partir del return
        return "index";
    }
    
}
