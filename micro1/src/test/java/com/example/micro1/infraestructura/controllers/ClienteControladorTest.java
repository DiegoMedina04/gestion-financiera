package com.example.micro1.infraestructura.controllers;

import com.example.micro1.application.servicios.ServicioCliente;
import com.example.micro1.domain.exceptions.RegisterNotFound;
import com.example.micro1.domain.models.Cliente;
import com.example.micro1.domain.models.Persona;
import jakarta.validation.Valid;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ClienteControladorTest {

    @Mock
    private  ServicioCliente servicioCliente;


    @InjectMocks
    private ClienteControlador clienteControlador;



    @Test
     public void testObtenerTodas() {
        List<Cliente> tareasEsperadas = List.of(
                new Cliente(1L, "Tarea 1", true,
                        new Persona(1L, "nombre",
                                "genero",
                                22,
                                1004844214,
                                1004844214,
                                "direccion"
                        ))
        );
        // Simula el comportamiento del servicio
        Mockito.when(servicioCliente.obtenerClientes()).thenReturn(tareasEsperadas);

        // Llamada al controlador
        ResponseEntity<?> tareasObtenidas = clienteControlador.obtenerClientes();

        // Verificación de la respuesta
        Assert.assertEquals(tareasEsperadas, tareasObtenidas.getBody());

        // Verifica que el método en el servicio se haya llamado
        Mockito.verify(servicioCliente).obtenerClientes();
    }

}
