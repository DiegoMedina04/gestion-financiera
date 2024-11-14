package com.example.micro2.infraestructura.models.Dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovimientoDTO {
    private Long id;
    private LocalDate fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;

    // Constructor
    public MovimientoDTO(Long id, LocalDate fecha, String tipoMovimiento, Double valor, Double saldo) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
    }

}
