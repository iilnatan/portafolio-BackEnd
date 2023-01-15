/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.Spring.Boot.Security.Dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marco
 */
@Getter @Setter
public class PersonaDto {

    @NotNull
    private int id;
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    @NotNull
    private String img;
    @NotNull
    private String descripcion;
    
    public PersonaDto(String nombre, String img, String descripcion) {
        this.nombre = nombre;
        this.img = img;
        this.descripcion = descripcion;
    }
}
