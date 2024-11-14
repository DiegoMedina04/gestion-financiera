package com.example.micro1.application.casosUsos.cliente;

import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.in.cliente.CrearClienteCasoUso;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;

public class CrearClienteUsoCasoImpl implements CrearClienteCasoUso {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public CrearClienteUsoCasoImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;

    }
    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepositoryPort.crearCliente(cliente);
    }
}

