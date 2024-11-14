package com.example.micro1.infraestructura.controllers;

import com.example.micro1.application.servicios.ServicioPersona;
import com.example.micro1.domain.models.Persona;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/persona")
public class PersonaControladorTest {

    private final ServicioPersona servicioPersona;

    public PersonaControladorTest(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }

    @GetMapping()
    public ResponseEntity<?> obtenerPersonas() {
        try {
            return  ResponseEntity.ok(servicioPersona.obtenerPersonas());
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPersonaPorId(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(servicioPersona.obtenerPersonaPorId(id));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@Valid @RequestBody Persona persona, BindingResult result) {
        try {
            if(result.hasErrors() ) {
                return  validarCamposObligatorios(result);
            }
            return  ResponseEntity.ok(servicioPersona.crearPersona(persona));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePerson( @RequestBody Persona persona) {
        try {
            return  ResponseEntity.ok(servicioPersona.actualizarPersona(persona));
        }catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(servicioPersona.eliminarPersonaCasoUso(id));
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

