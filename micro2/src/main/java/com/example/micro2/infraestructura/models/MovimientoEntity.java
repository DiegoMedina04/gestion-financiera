package com.example.micro2.infraestructura.models;


import com.example.micro2.domian.models.Movimiento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movimientos")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fecha;

    private String tipoMovimiento;

    private Double valor;


    private Double saldo;

    @ManyToOne
//    @JsonBackReference
    private CuentaEntity cuenta;

    public static MovimientoEntity fromDomainModel(Movimiento movimiento) {
        return new MovimientoEntity(
                movimiento.getId(),
                movimiento.getFecha(),
                movimiento.getTipoMovimiento(),
                movimiento.getValor(),
                movimiento.getSaldo(),
                movimiento.getCuenta()
        );
    }
    public Movimiento toDomainModel(){
        return new Movimiento(
                id,
                fecha,
                tipoMovimiento,
                valor,
                saldo,
                cuenta
        );
    }

}
