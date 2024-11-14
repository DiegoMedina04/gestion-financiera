package com.example.micro2.domian.ports.out;

import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovimientoRepositoryPort {

    List<Movimiento> obtenerMovimientos();
    Optional<Movimiento> obtenerMovimientoPorId(Long id);
    Movimiento agregarMovimiento(Movimiento movimiento);
    Movimiento actualizarMovimient(Movimiento movimiento);
    Boolean eliminarMovimiento(Long id );
    MovimientoResponseDTO obtenerMovimientosPorFechaYCliente(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId);
}
