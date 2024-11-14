package com.example.micro2.infraestructura.config;

import com.example.micro2.application.casosUsos.movimiento.*;
import com.example.micro2.application.servicios.MovimientoServicio;
import com.example.micro2.domian.ports.in.cuenta.ActualizarCuentaCasoUso;
import com.example.micro2.domian.ports.in.cuenta.ObtenerCuentasCasoUso;
import com.example.micro2.domian.ports.in.movimiento.*;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionMovimiento {

    @Bean
    public ObtenerMovimientosCasoUso obtenerPersonasCasoUso(MovimientoRepositoryPort movimientoRepository) {
        return new ObtenerMovimientosCasoUsoImpl(movimientoRepository);
    }

    @Bean
    public CrearMovimientoCasoUso crearMovimientoCasoUso(
            MovimientoRepositoryPort movimientoRepository,
            @Qualifier("obtenerCuentasCasoUsoBean") ObtenerCuentasCasoUso obtenerCuentasCasoUso,
            @Qualifier("actualizarClienteCasoUsoBean") ActualizarCuentaCasoUso actualizarCuentaCasoUso
    ) {
        return  new CrearMovimientoCasoUsoImpl(movimientoRepository, obtenerCuentasCasoUso,actualizarCuentaCasoUso);
    }

    @Bean
    public ActualizarMovimientoCasoUso actualizarPersonaCasoUso(
            MovimientoRepositoryPort movimientoRepository,
            ObtenerMovimientosCasoUso obtenerPersonasCasoUso,
            @Qualifier("obtenerCuentasCasoUsoBean") ObtenerCuentasCasoUso obtenerCuentasCasoUso,
            @Qualifier("actualizarClienteCasoUsoBean") ActualizarCuentaCasoUso actualizarCuentaCasoUso
            ) {
        return new ActualizarMovimientoCasoUsoImpl(
                movimientoRepository,
                obtenerPersonasCasoUso,
                obtenerCuentasCasoUso,
                actualizarCuentaCasoUso
        );
    }

    @Bean
    public EliminarMovimientoCasoUso eliminarPersonaCasoUso(MovimientoRepositoryPort movimientoRepository) {
        return new EliminarMovimientoCasoUsoImpl(movimientoRepository);
    }
    @Bean
    ObtenerMovimientosFechaClienteCasoUso obtenerMovimientosFechaClienteCasoUso(MovimientoRepositoryPort movimientoRepository){
        return new ObtenerMovimientosFechaClienteCasoUsoImpl(movimientoRepository);
    }

    @Bean
    public MovimientoServicio movimientoServicio (
            ObtenerMovimientosCasoUso obtenerMovimientosCasoUso,
            CrearMovimientoCasoUso crearMovimientoCasoUso,
            ActualizarMovimientoCasoUso actualizarMovimientoCasoUso,
            EliminarMovimientoCasoUso eliminarMovimientoCasoUso,
            ObtenerMovimientosFechaClienteCasoUso obtenerMovimientosFechaClienteCasoUso
    ) {
        return new MovimientoServicio(
                obtenerMovimientosCasoUso,
                crearMovimientoCasoUso,
                actualizarMovimientoCasoUso,
                eliminarMovimientoCasoUso,
                obtenerMovimientosFechaClienteCasoUso
        );
    }

}
