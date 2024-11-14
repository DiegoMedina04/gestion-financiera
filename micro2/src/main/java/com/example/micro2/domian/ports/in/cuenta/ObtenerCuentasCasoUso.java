package com.example.micro2.domian.ports.in.cuenta;

import com.example.micro2.domian.models.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ObtenerCuentasCasoUso {
    List<Cuenta> obtenerCuentas();
    Optional<Cuenta> obtenerCuentaPorId(Long id);
}
