package com.example.micro2.infraestructura.controllers;

import com.example.micro2.application.servicios.MovimientoServicio;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("reportes")
public class ReportesController {

    private final MovimientoServicio movimientoServicio;

    public ReportesController(MovimientoServicio movimientoServicio) {
        this.movimientoServicio = movimientoServicio;
    }

    @GetMapping()
    public ResponseEntity<?> obtenerReportes(
            @RequestParam("rangoFechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate rangoFechaInicio,
            @RequestParam("rangoFechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate rangoFechaFin,
            @RequestParam("clienteId") Long clienteId
    ) {
//        GET http://localhost:8080/reportes?rangoFechaInicio=2024-11-01&rangoFechaFin=2024-11-30&clienteId=123
        try {
            return  ResponseEntity.ok(movimientoServicio.obtenerMovimientosPorFechaYCliente(rangoFechaInicio, rangoFechaFin, clienteId));
        }catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
