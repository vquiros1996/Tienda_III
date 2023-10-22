/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_III.controller;

import com.Tienda_III.domain.Categoria;
import com.Tienda_III.service.CategoriaService;
import com.Tienda_III.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Vivian
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //me hace peticiones de tipo get
    @GetMapping("/listado")//se accede por este /listado
    public String inicio(Model model) {

        List<Categoria> listadoCategorias = categoriaService.getCategorias(false); //falso para que me muestr tds las ctag
        //con el objeto model usarlo como transporte entre controlador y la vista
        //  model.addAttribute(attributeName, categoriaService) USAR ESTE
        model.addAttribute("categorias", listadoCategorias); //utilizo el segundo el que tiene dos valores String atriute name y object
        model.addAttribute("totalCategorias", listadoCategorias.size());

        return "/categoria/listado";
    }

    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    //para FORMULARIOS envia mi objeto / atributos de categoria
    //pasa un parametro tipo MultipartFile
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {//viene alguna  imgen  if (!imagenFile.isEmpty() ?
        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            categoria.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        //retidecrt a la opcion de listado , el metodo de inicio
        //@GetMapping("/listado")//se accede por este /listado
        //public String inicio(Model model) 
        return "redirect:/categoria/listado";
    }

    //viene invocado desde un ancla por ese es de @GetMapping
    //el numero en el hover de la vista se ve gracias al ID idCategoria que se va mapeando
    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {//mapeado con la clase Categoria  que tambien tiene el idCategoria
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    //
    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }

}
