package com.example.micro1.application.casosUsos.persona;

import com.example.micro1.domain.ports.in.persona.EliminarPersonaCasoUso;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;

public class EliminarPersonaCasoUsoImpl implements EliminarPersonaCasoUso {
    private final PersonaRepositoryPort repository;

    public EliminarPersonaCasoUsoImpl(PersonaRepositoryPort repository) {
        this.repository = repository;
    }
    @Override
    public Boolean eliminarPersonaCasoUso(Long id ) {
        return repository.eliminarPersona(id);
    }
}
