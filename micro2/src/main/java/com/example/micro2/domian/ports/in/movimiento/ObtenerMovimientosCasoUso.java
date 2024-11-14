package com.example.micro2.domian.ports.in.movimiento;

import com.example.micro2.domian.models.Movimiento;

import java.util.List;
import java.util.Optional;

public interface ObtenerMovimientosCasoUso {

    List<Movimiento> obtenerMovimientosCasoUso();
    Optional<Movimiento> obtenerMovimientoPorId(Long id);
}
