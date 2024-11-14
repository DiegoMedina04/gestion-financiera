package com.example.micro1.infraestructura.repositories.persona;

import com.example.micro1.infraestructura.models.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
