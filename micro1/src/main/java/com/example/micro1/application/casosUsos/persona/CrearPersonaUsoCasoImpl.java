package com.example.micro1.application.casosUsos.persona;

import com.example.micro1.domain.models.Persona;
import com.example.micro1.domain.ports.in.persona.CrearPersonaCasoUso;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;

public class CrearPersonaUsoCasoImpl  implements CrearPersonaCasoUso {

    private final PersonaRepositoryPort repository;

    public CrearPersonaUsoCasoImpl(PersonaRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public Persona crearPersona(Persona persona) {
        return repository.crearPersona(persona);
    }
}
