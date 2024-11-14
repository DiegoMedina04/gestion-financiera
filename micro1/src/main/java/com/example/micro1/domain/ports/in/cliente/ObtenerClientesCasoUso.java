package com.example.micro1.domain.ports.in.cliente;

import com.example.micro1.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ObtenerClientesCasoUso {
    List<Cliente> obtenerClientes();
    Optional<Cliente> obtenerClientePorId(Long id);
}
