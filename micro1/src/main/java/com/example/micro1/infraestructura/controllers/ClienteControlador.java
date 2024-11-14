package com.example.micro1.infraestructura.controllers;

import com.example.micro1.application.servicios.ServicioCliente;
import com.example.micro1.domain.exceptions.RegisterNotFound;
import com.example.micro1.domain.models.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("cliente")
@CrossOrigin("*")
public class ClienteControlador {

    private final ServicioCliente servicioCliente;

    public ClienteControlador(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @GetMapping
    public ResponseEntity<?> obtenerClientes() {
        try {
            return  ResponseEntity.ok(servicioCliente.obtenerClientes());
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(servicioCliente.obtenerClientePorId(id));
        }catch (RegisterNotFound e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en el sistema");
        }
    }

    @PostMapping
    public ResponseEntity<?> crearCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        try {
            if(result.hasErrors()) {
                return validarCamposRequeridos(result);
            }
            return  ResponseEntity.ok(servicioCliente.create(cliente));
        }catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarCliente( @RequestBody Cliente cliente) {
        try {
            return  ResponseEntity.ok(servicioCliente.actualizarCliente(cliente));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(servicioCliente.eliminarClienteCaso(id));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<?> validarCamposRequeridos(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "el campo: "+error.getField()+ " "+ error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
