package com.example.micro2.infraestructura.repositories.movimiento;

import com.example.micro2.infraestructura.models.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaMovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    @Query("SELECT m FROM MovimientoEntity m " +
            "JOIN m.cuenta c " +
            "WHERE c.clienteId = :clienteId " +
            "AND m.fecha >= :fechaInicio " +
            "AND m.fecha < :fechaFin")
    List<MovimientoEntity> findMovimientosByFechaAndCliente(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("clienteId") Long clienteId);
}


