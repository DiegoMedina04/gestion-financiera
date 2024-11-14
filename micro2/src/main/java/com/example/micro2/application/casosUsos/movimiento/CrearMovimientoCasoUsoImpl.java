package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.exceptions.ErrorBadRequest;
import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.cuenta.ActualizarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.ObtenerCuentasCasoUso;
import com.example.micro2.domian.ports.in.movimiento.CrearMovimientoCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;

import java.util.Optional;

public class CrearMovimientoCasoUsoImpl implements CrearMovimientoCasoUso {

    private final ActualizarCuentaCasoUso actualizarCuentaCasoUso;
    private final MovimientoRepositoryPort movimientoRepositoryPort;
    private  final ObtenerCuentasCasoUso obtenerCuentasCasoUso;

    public CrearMovimientoCasoUsoImpl(
            MovimientoRepositoryPort movimientoRepositoryPort,
            ObtenerCuentasCasoUso obtenerCuentasCasoUso,
            ActualizarCuentaCasoUso actualizarCuentaCasoUso
    ) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
        this.obtenerCuentasCasoUso = obtenerCuentasCasoUso;
        this.actualizarCuentaCasoUso = actualizarCuentaCasoUso;
    }
    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        Optional<Cuenta> cuentaEncontrada = obtenerCuentasCasoUso.obtenerCuentaPorId(movimiento.getCuenta().getId());
        Cuenta cuenta=cuentaEncontrada.orElseThrow();
        if(movimiento.getValor()>cuenta.getSaldoInicial() ){
            throw new ErrorBadRequest("Saldo no disponible");
        }

        Double saldoTotal = cuenta.getSaldoInicial() - movimiento.getValor();
        cuenta.setSaldoInicial(saldoTotal);
        movimiento.setSaldo(saldoTotal);
        actualizarCuentaCasoUso.actualizarCuenta(cuenta);
        return movimientoRepositoryPort.agregarMovimiento(movimiento);
    }
}
