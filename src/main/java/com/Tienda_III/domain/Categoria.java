/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_III.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.Table;

/**
 *
 * @author Vivian
 */

//TIENE QUE TENER LOS MISMOS ATRIBUTOS DE LA BD , SE MAPEA CON LA BD
//RECORDAR NO PONER ESPACIOS***
@Data //nos ayuda a no tener que crear los set y get, se crean automatico con esta anotacion de los AT
@Entity //se le indica que CATEGORIA que es la clase se manejara como una entidad
@Table(name="categoria")//usams el imporor de jakarta, agregamos el nombre de la tabla que en este caso es categoria en min
public class Categoria implements Serializable {
private static final long serialVersionUID = 1L;

    //el int se maneja como un LONG 
    //no es necesario el underscore porque ese ya lo sabe transformar
    //En base datos con el underscore y en el neatbeans con el CammelCase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")//omo en la BD
    private Long idCategoria; //siempre lo trabajamos con CammelCase en neatbeans en BD va como id_categoria
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    //consructor vacio sin nada en base
    public Categoria() {
    }

    //constructor cargado lo puedo hacer con el boton derecho-insert code-constructor
    //marco todas menos el idCategoria, PORQUE este ya lo crea la BD y esta autoincrementado
    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

}
