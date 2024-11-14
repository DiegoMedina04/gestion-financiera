package com.example.micro1.domain.ports.out;


import com.example.micro1.domain.models.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepositoryPort {
    List<Persona> obtenerPersonas();
    Optional<Persona> buscarPersonaPorId(Long id);
    Persona crearPersona(Persona persona);
    Persona actualizarPersona(Persona persona);
    Boolean eliminarPersona(Long id);

}
