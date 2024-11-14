package com.example.micro2.infraestructura.models.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuentaDTO {
    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Long clienteId;

    // Constructor
    public CuentaDTO(Long id, Long numeroCuenta, String tipoCuenta, Double saldoInicial, Boolean estado, Long clienteId) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteId = clienteId;
    }
}
