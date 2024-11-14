package com.example.micro1.application.casosUsos.persona;

import com.example.micro1.domain.models.Persona;
import com.example.micro1.domain.ports.in.persona.ObtenerPersonasCasoUso;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ObtenerPersonasUseCasoImpl implements ObtenerPersonasCasoUso {
    private final PersonaRepositoryPort repository;

    public ObtenerPersonasUseCasoImpl(PersonaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return repository.obtenerPersonas();
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return repository.buscarPersonaPorId(id);
    }
}
