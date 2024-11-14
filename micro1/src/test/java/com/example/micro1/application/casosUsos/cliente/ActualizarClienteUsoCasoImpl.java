package com.example.micro1.application.casosUsos.cliente;

import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.in.cliente.ActualizarClienteCasoUso;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;

public class ActualizarClienteUsoCasoImpl implements ActualizarClienteCasoUso {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public ActualizarClienteUsoCasoImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;

    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepositoryPort.actualizarCliente(cliente);
    }
}
