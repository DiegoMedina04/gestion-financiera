package com.example.micro2.application.casosUsos.cuenta;

import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.ports.in.cuenta.ObtenerCuentasCasoUso;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ObtenerCuentasCasoUsoImpl implements ObtenerCuentasCasoUso {

    private final CuentaRepositoryPort cuentaRepositoryPort;

    public ObtenerCuentasCasoUsoImpl(CuentaRepositoryPort cuentaRepositoryPort) {
        this.cuentaRepositoryPort = cuentaRepositoryPort;
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentaRepositoryPort.obtenerCuentas();
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        System.out.println("Buscando la cuenta con el id: "+ id);
        return cuentaRepositoryPort.obtenerCuentaPorId(id);
    }
}
