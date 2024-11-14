package com.example.micro2.domian.ports.in.cuenta;

import com.example.micro2.application.Dtos.ClienteDto;

public interface BuscarClienteCasoUso {
    ClienteDto buscarCliente(Long id);
}
