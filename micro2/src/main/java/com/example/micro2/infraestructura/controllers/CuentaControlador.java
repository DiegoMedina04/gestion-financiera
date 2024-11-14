package com.example.micro2.infraestructura.controllers;

import com.example.micro2.application.servicios.CuentaServicio;
import com.example.micro2.domian.exceptions.RegisterNotFound;
import com.example.micro2.domian.models.Cuenta;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cuenta")
public class CuentaControlador {

    private final CuentaServicio cuentaServicio;

    public CuentaControlador(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }

    @GetMapping()
    public ResponseEntity<?> obtenerCuentas() {
        try {
            return  ResponseEntity.ok(cuentaServicio.obtenerCuentas());
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCuentaPorId(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(cuentaServicio.obtenerCuentaPorId(id));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> crearCuenta(@Valid @RequestBody Cuenta cuenta, BindingResult result) {
        System.out.println("Hola mudno");
        try {
            if(result.hasErrors() ) {
                return  validarCamposObligatorios(result);
            }
            return  ResponseEntity.ok(cuentaServicio.crearCuenta(cuenta));
        }catch (RegisterNotFound e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }  catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarCuenta( @RequestBody Cuenta cuenta) {
        try {
            return  ResponseEntity.ok(cuentaServicio.actualizarCuenta(cuenta));
        }catch (RegisterNotFound e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }  catch (Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(cuentaServicio.eliminarCuenta(id));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<?> validarCamposObligatorios(BindingResult result){
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), "el campo: "+error.getField()+ " "+ error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}

