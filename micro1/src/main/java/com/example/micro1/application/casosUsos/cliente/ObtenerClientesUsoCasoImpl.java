package com.example.micro1.application.casosUsos.cliente;

import com.example.micro1.domain.exceptions.RegisterNotFound;
import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.in.cliente.ObtenerClientesCasoUso;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ObtenerClientesUsoCasoImpl  implements ObtenerClientesCasoUso {


    private final ClienteRepositoryPort clienteRepositoryPort;

    public ObtenerClientesUsoCasoImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;

    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepositoryPort.buscarTodosClientes();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        Optional<Cliente> clienteOpcional=  clienteRepositoryPort.buscarClientePorid(id);
        if(clienteOpcional.isEmpty()){
            throw new  RegisterNotFound("Cliente no encontrado");
        }
        return clienteOpcional;
    }
}
