package com.example.micro2.infraestructura.models.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class MovimientoResponseDTO {

    private CuentaDTO cuenta;
    private List<MovimientoDTO> movimiento;


    public MovimientoResponseDTO(CuentaDTO cuenta, List<MovimientoDTO> movimiento ) {
        this.movimiento = movimiento;
        this.cuenta = cuenta;
    }
    public MovimientoResponseDTO(){

    }
}
