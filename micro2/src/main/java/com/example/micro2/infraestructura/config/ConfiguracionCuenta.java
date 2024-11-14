package com.example.micro2.infraestructura.config;

import com.example.micro2.application.casosUsos.cuenta.*;
import com.example.micro2.application.servicios.CuentaServicio;
import com.example.micro2.domian.ports.in.cuenta.*;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionCuenta {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public BuscarClienteCasoUso buscarClienteCasoUso(RestTemplate restTemplate) {
        return new BuscarClienteCasoUsoImpl(restTemplate);
    }

    @Bean
    public ObtenerCuentasCasoUso obtenerCuentasCasoUsoBean(CuentaRepositoryPort cuentaRepositoryPort) {
        return new ObtenerCuentasCasoUsoImpl(cuentaRepositoryPort);
    }

    @Bean
    public CrearCuentaCasoUso crearClienteCasoUso(
            CuentaRepositoryPort cuentaRepositoryPort,
            BuscarClienteCasoUso buscarClienteCasoUsos
    ) {
        return new CrearCuentaCasoUsoImpl(cuentaRepositoryPort, buscarClienteCasoUsos);
    }

    @Bean
    public ActualizarCuentaCasoUso actualizarClienteCasoUsoBean(
            CuentaRepositoryPort cuentaRepositoryPort,
            BuscarClienteCasoUso buscarClienteCasoUsos
    ) {
        return new ActualizarCuentaCasoUsoImpl(cuentaRepositoryPort, buscarClienteCasoUsos);
    }

    @Bean
    public EliminarCuentaCasoUso eliminarClienteCasoUso(CuentaRepositoryPort cuentaRepositoryPort) {
        return new EliminarCuentaCasoUsoImpl(cuentaRepositoryPort);
    }



}
