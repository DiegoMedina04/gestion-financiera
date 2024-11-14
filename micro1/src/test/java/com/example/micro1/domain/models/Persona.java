package com.example.micro1.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String genero;

    @NotNull
    private int edad;

    @NotNull
    private Integer identificacion;

    @NotNull
    private Integer telefono;

    @NotNull
    private  String direccion;

    private  Cliente cliente;

    public Persona(Long id, String nombre, String genero, int edad, Integer identificacion, Integer telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
