package com.example.micro1.domain.ports.in.persona;

import com.example.micro1.domain.models.Persona;

import java.util.List;
import java.util.Optional;

public interface ObtenerPersonasCasoUso {

    List<Persona> obtenerPersonas();
    Optional<Persona> obtenerPersonaPorId(Long id);
}
