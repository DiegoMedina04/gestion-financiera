package com.example.micro2.application.Dtos;

import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerMovimientosDto {
    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Long clienteId;
    private List<MovimientoDTO> movimientos;
}
