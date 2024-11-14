package com.example.micro1.application.servicios;

import com.example.micro1.domain.models.Persona;
import com.example.micro1.domain.ports.in.persona.ActualizarPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.CrearPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.EliminarPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.ObtenerPersonasCasoUso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPersona implements ObtenerPersonasCasoUso, CrearPersonaCasoUso, ActualizarPersonaCasoUso, EliminarPersonaCasoUso {

    private final ObtenerPersonasCasoUso obtenerPersonasCasoUso;
    private final CrearPersonaCasoUso crearPersonaCasoUso;
    private final ActualizarPersonaCasoUso actualizarPersonaCasoUso;
    private final EliminarPersonaCasoUso eliminarPersonaCasoUso;

    public ServicioPersona(ObtenerPersonasCasoUso obtenerPersonasCasoUso, CrearPersonaCasoUso crearPersonaCasoUso, ActualizarPersonaCasoUso actualizarPersonaCasoUso, EliminarPersonaCasoUso eliminarPersonaCasoUso) {
        this.obtenerPersonasCasoUso = obtenerPersonasCasoUso;
        this.crearPersonaCasoUso = crearPersonaCasoUso;
        this.actualizarPersonaCasoUso = actualizarPersonaCasoUso;
        this.eliminarPersonaCasoUso = eliminarPersonaCasoUso;
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return obtenerPersonasCasoUso.obtenerPersonas();
    }

    @Override
    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return obtenerPersonasCasoUso.obtenerPersonaPorId(id);
    }


    @Override
    public Persona crearPersona(Persona persona) {
        return crearPersonaCasoUso.crearPersona(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return actualizarPersonaCasoUso.actualizarPersona(persona);
    }

    @Override
    public Boolean eliminarPersonaCasoUso(Long id) {
        return eliminarPersonaCasoUso.eliminarPersonaCasoUso(id);
    }

}
