package com.example.micro1.infraestructura.models;

import com.example.micro1.domain.models.Persona;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String genero;

    private int edad;

    private Integer identificacion;

    private Integer telefono;

    private  String direccion;

    @OneToOne(mappedBy = "persona")
    private ClienteEntity cliente;

    public PersonaEntity(Long id, String nombre, String genero, int edad, Integer identificacion, Integer telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public static PersonaEntity fromDomainModel(Persona persona) {
        return new PersonaEntity(
                persona.getId(),
                persona.getNombre(),
                persona.getGenero(),
                persona.getEdad(),
                persona.getIdentificacion(),
                persona.getTelefono(),
                persona.getDireccion()
        );
    }

    public Persona toDomainModel(){
        return new Persona(
                id,
                nombre,
                genero,
                edad,
                identificacion,
                telefono,
                direccion
        );
    }
}
