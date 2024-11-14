package com.example.micro1.infraestructura.config;

import com.example.micro1.application.casosUsos.persona.ActualizarPersonaCasoUsoImpl;
import com.example.micro1.application.casosUsos.persona.CrearPersonaUsoCasoImpl;
import com.example.micro1.application.casosUsos.persona.EliminarPersonaCasoUsoImpl;
import com.example.micro1.application.casosUsos.persona.ObtenerPersonasUseCasoImpl;
import com.example.micro1.domain.ports.in.persona.ActualizarPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.CrearPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.EliminarPersonaCasoUso;
import com.example.micro1.domain.ports.in.persona.ObtenerPersonasCasoUso;
import com.example.micro1.domain.ports.out.PersonaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionPersona {

    @Bean
    public ObtenerPersonasCasoUso obtenerPersonasCasoUso(PersonaRepositoryPort personaRepository) {
        return new ObtenerPersonasUseCasoImpl(personaRepository);
    }

    @Bean
    public CrearPersonaCasoUso crearPersonaCasoUso(PersonaRepositoryPort personaRepository) {
        return  new CrearPersonaUsoCasoImpl(personaRepository);
    }

    @Bean
    public ActualizarPersonaCasoUso actualizarPersonaCasoUso(PersonaRepositoryPort personaRepository) {
        return new ActualizarPersonaCasoUsoImpl(personaRepository);
    }

    @Bean
    public EliminarPersonaCasoUso eliminarPersonaCasoUso(PersonaRepositoryPort personaRepository) {
        return new EliminarPersonaCasoUsoImpl(personaRepository);
    }

}
