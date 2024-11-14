package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.ports.in.movimiento.ObtenerMovimientosFechaClienteCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;
import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class ObtenerMovimientosFechaClienteCasoUsoImpl implements ObtenerMovimientosFechaClienteCasoUso {

    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public ObtenerMovimientosFechaClienteCasoUsoImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }


    @Override
    public MovimientoResponseDTO obtenerMovimientosPorFechaYCliente(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId) {
        return movimientoRepositoryPort.obtenerMovimientosPorFechaYCliente(fechaInicio, fechaFin, clienteId);
    }
}
