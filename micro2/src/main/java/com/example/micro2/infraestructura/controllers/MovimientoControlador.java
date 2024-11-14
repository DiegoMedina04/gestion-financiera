package com.example.micro2.infraestructura.controllers;

import com.example.micro2.application.servicios.MovimientoServicio;
import com.example.micro2.domian.exceptions.ErrorBadRequest;
import com.example.micro2.domian.models.Movimiento;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("movimiento")
public class MovimientoControlador {

    private final MovimientoServicio movimientoServicio;

    public MovimientoControlador(MovimientoServicio movimientoServicio) {
        this.movimientoServicio = movimientoServicio;
    }

    @GetMapping
    public ResponseEntity<?> obtenerMovimiento() {
        try {
            return  ResponseEntity.ok(movimientoServicio.obtenerMovimientosCasoUso());
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerMovimientoPorId(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(movimientoServicio.obtenerMovimientoPorId(id));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> crearMovimiento(@Valid @RequestBody Movimiento movimiento, BindingResult result) {
        try {
            System.out.println("creando controlador");
            if(result.hasErrors()) {
                return validarCamposRequeridos(result);
            }
            return  ResponseEntity.ok(movimientoServicio.crearMovimiento(movimiento));
        }catch (ErrorBadRequest e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarMovimiento( @RequestBody Movimiento movimiento) {
        try {
            return  ResponseEntity.ok(movimientoServicio.actualizarMovimiento(movimiento));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMovimiento(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(movimientoServicio.eliminarMovimiento(id));
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
