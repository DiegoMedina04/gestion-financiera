package com.example.micro1.infraestructura.repositories.cliente;

import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.ports.out.ClienteRepositoryPort;
import com.example.micro1.infraestructura.models.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final JpaClienteRepository jpaClienteRepository;

    public JpaClienteRepositoryAdapter(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return jpaClienteRepository
                .findAll()
                .stream()
                .map(ClienteEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Cliente> buscarClientePorid(Long id) {
        return jpaClienteRepository.findById(id).map(ClienteEntity::toDomainModel);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteEntity.fromDomainModel(cliente);
        ClienteEntity clienteEntitySaved = jpaClienteRepository.save(clienteEntity);
        return clienteEntitySaved.toDomainModel();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteEntity.fromDomainModel(cliente);
        ClienteEntity clienteEntitySaved = jpaClienteRepository.save(clienteEntity);
        return clienteEntitySaved.toDomainModel();
    }

    @Override
    public Boolean eliminarCliente(Long id ) {
        if(jpaClienteRepository.existsById(id)) {
            jpaClienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
