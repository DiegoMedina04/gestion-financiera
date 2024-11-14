package com.example.micro2.application.servicios;

import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.ports.in.cuenta.ActualizarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.CrearCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.EliminarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.ObtenerCuentasCasoUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServicio implements ObtenerCuentasCasoUso, CrearCuentaCasoUso, ActualizarCuentaCasoUso, EliminarCuentaCasoUso {

    private final ObtenerCuentasCasoUso obtenerCuentasCasoUso;
    private final CrearCuentaCasoUso crearCuentaCasoUso;
    private final ActualizarCuentaCasoUso actualizarCuentaCasoUso;
    private final EliminarCuentaCasoUso eliminarCuentaCasoUso;

    public CuentaServicio(
            ObtenerCuentasCasoUso obtenerCuentasCasoUso,
            CrearCuentaCasoUso crearCuentaCasoUso,
            ActualizarCuentaCasoUso actualizarCuentaCasoUso,
            EliminarCuentaCasoUso eliminarCuentaCasoUso
    ) {
        this.obtenerCuentasCasoUso = obtenerCuentasCasoUso;
        this.crearCuentaCasoUso = crearCuentaCasoUso;
        this.actualizarCuentaCasoUso = actualizarCuentaCasoUso;
        this.eliminarCuentaCasoUso = eliminarCuentaCasoUso;
    }


    @Override
    public List<Cuenta> obtenerCuentas() {
        return obtenerCuentasCasoUso.obtenerCuentas();
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return obtenerCuentasCasoUso.obtenerCuentaPorId(id);
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {

        return crearCuentaCasoUso.crearCuenta(cuenta);
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return actualizarCuentaCasoUso.actualizarCuenta(cuenta);
    }

    @Override
    public Boolean eliminarCuenta(Long id) {
        return eliminarCuentaCasoUso.eliminarCuenta(id);
    }

}
