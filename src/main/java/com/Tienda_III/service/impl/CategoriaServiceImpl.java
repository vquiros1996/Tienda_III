/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_III.service.impl;

import com.Tienda_III.dao.CategoriaDao;
import com.Tienda_III.domain.Categoria;
import com.Tienda_III.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivian
 */
//TODAS mis clases de implementacion van con el @service
//HACER EL IMPLEMENT DE ALL ABSTRACT
@Service
public class CategoriaServiceImpl implements CategoriaService {

    //Autowired nos sirve para traer dependencias del Dao
    //para poder usar la variable categoriaDao en os demas publics
    @Autowired
    private CategoriaDao categoriaDao;

    //METODO QUE RETORNA 1 LISTA***
    //va conectado con la clase CategoriaService todo lo que va ahi se hace aca con los implement abstract
    @Override
    @Transactional(readOnly = true) //uso el importe de spring en vez de jakarta en este readOnly=true
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> categorias = categoriaDao.findAll(); // el findAll me permite buscar/encontrar todo
        if (activos) {
            //remover si C es true el isActivo() metodo viene de mi lombok libreria, es con IS porque es boolean
            categorias.removeIf(c -> !c.isActivo()); // al texto de la C se le puede poner cualqueir otta cosa, categoria o lo que uno quiera
        }

        return categorias;
    }

    //METODO QUE RETORNA UNA SOLA LISTA***
    @Override
    public Categoria getCategoria(Categoria categoria) {

        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);

    }

    //METODO QUE VIENE TAMBIEN EN CATEGORIASERVICE insertar, modificar o eliminar si tienen el @Transactional
    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    //METODO QUE VIENE TAMBIEN EN CATEGORIASERVICE
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }


    //metodo para buscar, filtrar
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategoriasPorDescripcion(String descripcion) {
        return categoriaDao.findByDescripcionContainingIgnoreCase(descripcion);
    }

}
