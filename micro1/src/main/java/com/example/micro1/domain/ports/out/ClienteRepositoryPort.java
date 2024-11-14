package com.example.micro1.domain.ports.out;

import com.example.micro1.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    List<Cliente> buscarTodosClientes();
    Optional<Cliente> buscarClientePorid(Long id);
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Boolean eliminarCliente(Long id);

}
