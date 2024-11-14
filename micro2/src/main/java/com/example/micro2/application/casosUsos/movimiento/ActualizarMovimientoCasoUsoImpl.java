package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.movimiento.ActualizarMovimientoCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;

public class ActualizarMovimientoCasoUsoImpl implements ActualizarMovimientoCasoUso {

    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public ActualizarMovimientoCasoUsoImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return movimientoRepositoryPort.actualizarMovimient(movimiento);
    }
}
