package com.example.micro2.application.casosUsos.cuenta;

import com.example.micro2.domian.ports.in.cuenta.EliminarCuentaCasoUso;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;

public class EliminarCuentaCasoUsoImpl implements EliminarCuentaCasoUso {

    private final CuentaRepositoryPort cuentaRepositoryPort;

    public EliminarCuentaCasoUsoImpl(CuentaRepositoryPort cuentaRepositoryPort) {
        this.cuentaRepositoryPort = cuentaRepositoryPort;
    }

    @Override
    public Boolean eliminarCuenta(Long id) {
        return cuentaRepositoryPort.eliminarCuenta(id);
    }
}
