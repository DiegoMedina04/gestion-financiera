package com.example.micro2.domian.models;

import com.example.micro2.infraestructura.models.CuentaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {

    private Long id;

    private LocalDate fecha;

    private String tipoMovimiento;

    private Double valor;

    private Double saldo;

    private CuentaEntity cuenta;

}
