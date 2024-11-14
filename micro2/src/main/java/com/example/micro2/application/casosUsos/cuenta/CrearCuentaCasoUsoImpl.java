package com.example.micro2.application.casosUsos.cuenta;

import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.ports.in.cuenta.BuscarClienteCasoUso;
import com.example.micro2.domian.ports.in.cuenta.CrearCuentaCasoUso;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;

public class CrearCuentaCasoUsoImpl implements CrearCuentaCasoUso {
    private final CuentaRepositoryPort cuentaRepositoryPort;
    private final BuscarClienteCasoUso buscarClienteCasoUso;


    public CrearCuentaCasoUsoImpl(
            CuentaRepositoryPort cuentaRepositoryPort,
            BuscarClienteCasoUso buscarClienteCasoUso
    ) {
        this.cuentaRepositoryPort = cuentaRepositoryPort;
        this.buscarClienteCasoUso = buscarClienteCasoUso;
    }
    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        buscarClienteCasoUso.buscarCliente(cuenta.getClienteId());
        return cuentaRepositoryPort.guardarCuenta(cuenta);
    }
}
