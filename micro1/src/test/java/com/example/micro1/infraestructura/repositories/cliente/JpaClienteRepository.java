package com.example.micro1.infraestructura.repositories.cliente;

import com.example.micro1.infraestructura.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
