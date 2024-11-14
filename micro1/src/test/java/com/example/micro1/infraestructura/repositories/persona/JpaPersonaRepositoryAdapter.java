package com.example.micro1.infraestructura.repositories.persona;

import com.example.micro1.domain.models.Persona;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;
import com.example.micro1.infraestructura.models.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaPersonaRepositoryAdapter implements PersonaRepositoryPort {

    private final JpaPersonaRepository jpaPersonaRepository;

    public JpaPersonaRepositoryAdapter(JpaPersonaRepository jpaPersonaRepository) {
        this.jpaPersonaRepository = jpaPersonaRepository;
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return jpaPersonaRepository
                .findAll()
                .stream()
                .map(PersonaEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Persona> buscarPersonaPorId(Long id) {
        return jpaPersonaRepository.findById(id).map(PersonaEntity::toDomainModel);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
        PersonaEntity personaGuardada = jpaPersonaRepository.save(personaEntity);
        return personaGuardada.toDomainModel();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
        PersonaEntity personaGuardada = jpaPersonaRepository.save(personaEntity);
        return personaGuardada.toDomainModel();
    }

    @Override
    public Boolean eliminarPersona(Long id) {
        if(jpaPersonaRepository.existsById(id)) {
            jpaPersonaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
