package com.example.micro2.application.servicios;

import com.example.micro2.application.Dtos.ObtenerMovimientosDto;
import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.movimiento.*;
import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;
import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServicio implements ObtenerMovimientosCasoUso, CrearMovimientoCasoUso, ActualizarMovimientoCasoUso, EliminarMovimientoCasoUso, ObtenerMovimientosFechaClienteCasoUso {

    private final ObtenerMovimientosCasoUso obtenerMovimientosCasoUso;
    private final CrearMovimientoCasoUso crearMovimientoCasoUso;
    private final ActualizarMovimientoCasoUso actualizarMovimientoCasoUso;
    private final EliminarMovimientoCasoUso eliminarMovimientoCasoUso;
    private final ObtenerMovimientosFechaClienteCasoUso obtenerMovimientosFechaClienteCasoUso;


    public MovimientoServicio(
            ObtenerMovimientosCasoUso obtenerMovimientosCasoUso,
            CrearMovimientoCasoUso crearMovimientoCasoUso,
            ActualizarMovimientoCasoUso actualizarMovimientoCasoUso,
            EliminarMovimientoCasoUso eliminarMovimientoCasoUso,
            ObtenerMovimientosFechaClienteCasoUso obtenerMovimientosFechaClienteCasoUso
            ) {
        this.obtenerMovimientosCasoUso = obtenerMovimientosCasoUso;
        this.crearMovimientoCasoUso = crearMovimientoCasoUso;
        this.actualizarMovimientoCasoUso = actualizarMovimientoCasoUso;
        this.eliminarMovimientoCasoUso = eliminarMovimientoCasoUso;
        this.obtenerMovimientosFechaClienteCasoUso= obtenerMovimientosFechaClienteCasoUso;
    }


    @Override
    public List<ObtenerMovimientosDto> obtenerMovimientosCasoUso() {
        return obtenerMovimientosCasoUso.obtenerMovimientosCasoUso();
    }

    @Override
    public Optional<MovimientoDTO> obtenerMovimientoPorId(Long id) {
        return obtenerMovimientosCasoUso.obtenerMovimientoPorId(id);
    }

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        System.out.println("creando en el servicio ");
        return crearMovimientoCasoUso.crearMovimiento(movimiento);
    }


    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return actualizarMovimientoCasoUso.actualizarMovimiento(movimiento);
    }

    @Override
    public Boolean eliminarMovimiento(Long id) {
        return eliminarMovimientoCasoUso.eliminarMovimiento(id);
    }

    @Override
    public MovimientoResponseDTO obtenerMovimientosPorFechaYCliente(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId) {
        return obtenerMovimientosFechaClienteCasoUso.obtenerMovimientosPorFechaYCliente(fechaInicio, fechaFin, clienteId);
    }

}
