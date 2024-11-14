package com.example.micro2.domian.models;

import com.example.micro2.infraestructura.models.MovimientoEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Cuenta {

    private Long id;

    @NotNull
    private Long numeroCuenta;

    @NotNull
    private String tipoCuenta;

    @NotNull
    private Double saldoInicial;

    @NotNull
    private Boolean estado;

    @NotNull
    private Long clienteId;

    private List<MovimientoEntity> movimientos;

    public Cuenta(Long id, Long numeroCuenta, String tipoCuenta, Double saldoInicial, Boolean estado, Long clienteId) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteId = clienteId;
    }
}
