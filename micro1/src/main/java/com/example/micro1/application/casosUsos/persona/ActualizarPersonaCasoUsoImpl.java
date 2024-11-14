package com.example.micro1.application.casosUsos.persona;

import com.example.micro1.domain.models.Persona;
import com.example.micro1.domain.ports.in.persona.ActualizarPersonaCasoUso;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;

public class ActualizarPersonaCasoUsoImpl implements ActualizarPersonaCasoUso {

    private final PersonaRepositoryPort repository;

    public ActualizarPersonaCasoUsoImpl(PersonaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return repository.actualizarPersona(persona);
    }
}
