package com.example.micro1.application.servicios;

import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.in.cliente.ActualizarClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.CrearClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.EliminarClienteCasoUso;
import com.example.micro1.domain.ports.in.cliente.ObtenerClientesCasoUso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente implements ObtenerClientesCasoUso, CrearClienteCasoUso, ActualizarClienteCasoUso, EliminarClienteCasoUso {

    private final ObtenerClientesCasoUso obtenerClientesCasoUso;
    private final CrearClienteCasoUso crearClienteCasoUso;
    private final ActualizarClienteCasoUso actualizarClienteCasoUso;
    private final EliminarClienteCasoUso eliminarClienteCasoUso;

    public ServicioCliente(ObtenerClientesCasoUso obtenerClientesCasoUso, CrearClienteCasoUso crearClienteCasoUso, ActualizarClienteCasoUso actualizarClienteCasoUso, EliminarClienteCasoUso eliminarClienteCasoUso) {
        this.obtenerClientesCasoUso = obtenerClientesCasoUso;
        this.crearClienteCasoUso = crearClienteCasoUso;
        this.actualizarClienteCasoUso = actualizarClienteCasoUso;
        this.eliminarClienteCasoUso = eliminarClienteCasoUso;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return obtenerClientesCasoUso.obtenerClientes();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return obtenerClientesCasoUso.obtenerClientePorId(id);
    }


    @Override
    public Cliente create(Cliente cliente) {
        return crearClienteCasoUso.create(cliente);
    }
    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return actualizarClienteCasoUso.actualizarCliente(cliente);
    }

    @Override
    public Boolean eliminarClienteCaso(Long id) {
        return eliminarClienteCasoUso.eliminarClienteCaso(id);
    }


}
