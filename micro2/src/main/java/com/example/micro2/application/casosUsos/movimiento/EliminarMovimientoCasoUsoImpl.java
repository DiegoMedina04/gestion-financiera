package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.ports.in.movimiento.EliminarMovimientoCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;

public class EliminarMovimientoCasoUsoImpl implements EliminarMovimientoCasoUso {

    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public EliminarMovimientoCasoUsoImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }

    @Override
    public Boolean eliminarMovimiento(Long id) {
        return movimientoRepositoryPort.eliminarMovimiento(id);
    }
}
