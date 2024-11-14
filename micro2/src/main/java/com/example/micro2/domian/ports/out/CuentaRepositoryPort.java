package com.example.micro2.domian.ports.out;

import com.example.micro2.domian.models.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepositoryPort {

    List<Cuenta> obtenerCuentas();
    Optional<Cuenta> obtenerCuentaPorId(Long id);
    Cuenta guardarCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta(Cuenta cuenta);
    Boolean eliminarCuenta(Long id );
}
