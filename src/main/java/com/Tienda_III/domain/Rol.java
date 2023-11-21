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
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Vivian
 */
@Data //Para la creacion automatica de los sets y gets de los atributos
@Entity //esta clase se va a manejar como entidad
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ES EL ID y es auto incrmental
    @Column(name = "id_rol") //cuando se le cambia el nombre al atributo
    private Long idRol;

    @NotEmpty
    private String nombre;

    @Column(name = "id_usuario")
    private Long idUsuario;

}
