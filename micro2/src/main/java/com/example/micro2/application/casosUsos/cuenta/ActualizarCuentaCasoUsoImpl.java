package com.example.micro2.application.casosUsos.cuenta;

import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.ports.in.cuenta.ActualizarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.BuscarClienteCasoUso;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;

public class ActualizarCuentaCasoUsoImpl implements ActualizarCuentaCasoUso {
    private final CuentaRepositoryPort cuentaRepositoryPort;
    private final BuscarClienteCasoUso buscarClienteCasoUso;

    public ActualizarCuentaCasoUsoImpl(
            CuentaRepositoryPort cuentaRepositoryPort,
            BuscarClienteCasoUso buscarClienteCasoUso
    ) {
        this.cuentaRepositoryPort = cuentaRepositoryPort;
        this.buscarClienteCasoUso = buscarClienteCasoUso;
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        buscarClienteCasoUso.buscarCliente(cuenta.getClienteId());
        return cuentaRepositoryPort.actualizarCuenta(cuenta);
    }
}
