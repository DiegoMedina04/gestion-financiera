package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.domian.exceptions.ErrorBadRequest;
import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.cuenta.ActualizarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.ObtenerCuentasCasoUso;
import com.example.micro2.domian.ports.in.movimiento.ActualizarMovimientoCasoUso;
import com.example.micro2.domian.ports.in.movimiento.ObtenerMovimientosCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;
import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;

import java.util.Optional;

public class ActualizarMovimientoCasoUsoImpl implements ActualizarMovimientoCasoUso {

    private final MovimientoRepositoryPort movimientoRepositoryPort;
    private final ObtenerMovimientosCasoUso obtenerMovimientosCasoUso;
    private final ObtenerCuentasCasoUso obtenerCuentasCasoUso;
    private final ActualizarCuentaCasoUso actualizarCuentaCasoUso;

    public ActualizarMovimientoCasoUsoImpl(
            MovimientoRepositoryPort movimientoRepositoryPort,
            ObtenerMovimientosCasoUso obtenerMovimientosCasoUso,
            ObtenerCuentasCasoUso obtenerCuentasCasoUso,
            ActualizarCuentaCasoUso actualizarCuentaCasoUso
            
    ) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
        this.obtenerMovimientosCasoUso = obtenerMovimientosCasoUso;
        this.obtenerCuentasCasoUso = obtenerCuentasCasoUso;
        this.actualizarCuentaCasoUso = actualizarCuentaCasoUso;
    }

    @Override
    public Movimiento actualizarMovimiento(Movimiento movimientoNuevo) {

        Optional<MovimientoDTO> movimientoOptional= obtenerMovimientosCasoUso.obtenerMovimientoPorId(movimientoNuevo.getId());
        MovimientoDTO movimientoEncontrado = movimientoOptional.orElseThrow();
        System.out.println("cuenta "+ movimientoNuevo.getCuenta().getId());
        Optional<Cuenta> cuentaEncontrada = obtenerCuentasCasoUso.obtenerCuentaPorId(movimientoNuevo.getCuenta().getId());
        Cuenta cuenta= cuentaEncontrada.orElseThrow();
        if(movimientoNuevo.getValor()>cuenta.getSaldoInicial() ){
            throw new ErrorBadRequest("Saldo no disponible");
        }


        Cuenta cuentaActualizada = getCuenta(movimientoNuevo, cuenta, movimientoEncontrado);
        actualizarCuentaCasoUso.actualizarCuenta(cuentaActualizada);
        return movimientoRepositoryPort.actualizarMovimient(movimientoNuevo);
    }

    private static Cuenta getCuenta(Movimiento movimientoNuevo, Cuenta cuentaEncontrada, MovimientoDTO movimientoEncontrado) {


        double valorDiferencia = movimientoNuevo.getValor() - movimientoEncontrado.getValor();
        cuentaEncontrada.setSaldoInicial(cuentaEncontrada.getSaldoInicial() - valorDiferencia);

        return cuentaEncontrada;
    }
}
