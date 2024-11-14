package com.example.micro2.domian.ports.in.movimiento;

import com.example.micro2.application.Dtos.ObtenerMovimientosDto;
import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;
import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ObtenerMovimientosCasoUso {

    List<ObtenerMovimientosDto> obtenerMovimientosCasoUso();
    Optional<MovimientoDTO> obtenerMovimientoPorId(Long id);
}
