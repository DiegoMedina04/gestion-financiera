package com.example.micro1.application.casosUsos.cliente;

import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.in.cliente.EliminarClienteCasoUso;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;

public class EliminarClienteUsoCasoImpl implements EliminarClienteCasoUso {


    private final ClienteRepositoryPort clienteRepositoryPort;

    public EliminarClienteUsoCasoImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;

    }
    @Override
    public Boolean eliminarClienteCaso(Long id) {
        return clienteRepositoryPort.eliminarCliente(id);
    }
}
