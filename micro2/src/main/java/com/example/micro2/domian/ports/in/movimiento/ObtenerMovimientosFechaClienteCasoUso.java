package com.example.micro2.domian.ports.in.movimiento;


import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;

import java.time.LocalDate;
import java.util.List;


public interface ObtenerMovimientosFechaClienteCasoUso {

    MovimientoResponseDTO obtenerMovimientosPorFechaYCliente(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId);
}
