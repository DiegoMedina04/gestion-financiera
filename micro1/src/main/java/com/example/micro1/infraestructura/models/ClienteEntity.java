package com.example.micro1.infraestructura.models;

import com.example.micro1.domain.models.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contrasena;

    private Boolean estado;

    @OneToOne
    private PersonaEntity persona;

    public static  ClienteEntity fromDomainModel(Cliente cliente){
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(cliente.getPersona());
        return  new ClienteEntity(
                cliente.getId(),
                cliente.getContrasena(),
                cliente.getEstado(),
                personaEntity
        );
    }

    public Cliente toDomainModel(){
        return new Cliente( id, contrasena, estado, persona.toDomainModel() );
    }
}
