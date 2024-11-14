package com.example.micro2.infraestructura.repositories.cuenta;

import com.example.micro2.infraestructura.models.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
