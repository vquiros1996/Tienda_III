/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_III.service;

import com.Tienda_III.domain.Categoria;
import java.util.List;

/**
 *
 * @author Vivian
 */
//sera como el MENU de nosotros, nos permite conectarse
//con las otras cetegorias
//vamos a tener metodos de salvar/ eliminar/ buscar categorias
//como un "CRUD"
public interface CategoriaService {

    //valor de retorno una lista de categoria
    //un solo objeto singular, categorias para el objeto
    //parametro a recibir un booleano de activos , ya sea para traer tdas
    //o algunas de las categorias
    //el activos nos sirve para traer todas las categorias que esten activas
    //RETORNA UNA LISTA DE CAT (ACTIVAS O TODAS
    public List<Categoria> getCategorias(boolean activos);

    //RETORNA UNA CATEGORIA POR ID
    public Categoria getCategoria(Categoria categoria);

    //SE INSERTA UN NUEVO REGISTRO SI EL ID DE LA CATEGORIA ESTA VACIO
    //SE ACTUALIZA EL REGISTRO SI EL ID DE LA CATEGORIA NO ESTA VACIO
    public void save(Categoria categoria);

    public void delete(Categoria categoria);

    //metodo para buscar, filtrar
    public List<Categoria> getCategoriasPorDescripcion(String descripcion);

}
