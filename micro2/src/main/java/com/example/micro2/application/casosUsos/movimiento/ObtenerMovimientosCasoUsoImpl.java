package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.movimiento.ObtenerMovimientosCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ObtenerMovimientosCasoUsoImpl implements ObtenerMovimientosCasoUso {


    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public ObtenerMovimientosCasoUsoImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public List<Movimiento> obtenerMovimientosCasoUso() {
        return movimientoRepositoryPort.obtenerMovimientos();
    }

    @Override
    public Optional<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoRepositoryPort.obtenerMovimientoPorId(id);
    }
}
