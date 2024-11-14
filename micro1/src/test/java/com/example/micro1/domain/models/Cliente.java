package com.example.micro1.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Long id;

    @NotNull
    private String contrasena;

    @NotNull
    private Boolean estado;

    @NotNull
    private Persona persona;


}
