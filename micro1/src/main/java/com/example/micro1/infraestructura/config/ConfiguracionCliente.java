package com.example.micro1.infraestructura.config;

import com.example.micro1.application.casosUsos.cliente.ActualizarClienteUsoCasoImpl;
import com.example.micro1.application.casosUsos.cliente.CrearClienteUsoCasoImpl;
import com.example.micro1.application.casosUsos.cliente.EliminarClienteUsoCasoImpl;
import com.example.micro1.application.casosUsos.cliente.ObtenerClientesUsoCasoImpl;
import com.example.micro1.domain.ports.in.cliente.ActualizarClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.CrearClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.EliminarClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.ObtenerClientesCasoUso;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionCliente {

    @Bean
    public ObtenerClientesCasoUso obtenerClientesCasoUso(ClienteRepositoryPort clienteRepository) {
        return new ObtenerClientesUsoCasoImpl(clienteRepository);
    }

    @Bean
    public CrearClienteCasoUso crearClienteCasoUso(ClienteRepositoryPort clienteRepository) {
        return new CrearClienteUsoCasoImpl(clienteRepository);
    }

    @Bean
    public ActualizarClienteCasoUso actualizarClienteCasoUso(ClienteRepositoryPort clienteRepository) {
        return new ActualizarClienteUsoCasoImpl(clienteRepository);
    }

    @Bean
    public EliminarClienteCasoUso eliminarClienteCasoUso(ClienteRepositoryPort clienteRepository) {
        return new EliminarClienteUsoCasoImpl(clienteRepository);
    }
}
