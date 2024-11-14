package com.example.micro2.application.casosUsos.movimiento;

import com.example.micro2.application.Dtos.ObtenerMovimientosDto;
import com.example.micro2.domian.exceptions.RegisterNotFound;
import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.in.movimiento.ObtenerMovimientosCasoUso;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;
import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ObtenerMovimientosCasoUsoImpl implements ObtenerMovimientosCasoUso {


    private final MovimientoRepositoryPort movimientoRepositoryPort;

    public ObtenerMovimientosCasoUsoImpl(MovimientoRepositoryPort movimientoRepositoryPort) {
        this.movimientoRepositoryPort = movimientoRepositoryPort;
    }


    @Override
    public Optional<MovimientoDTO> obtenerMovimientoPorId(Long id) {
        Optional<Movimiento> movientoOpcional =  movimientoRepositoryPort.obtenerMovimientoPorId(id);
        if(movientoOpcional.isEmpty()){
            throw new RegisterNotFound("Movimiento no encontrado");
        }
        Movimiento movimiento = movientoOpcional.orElseThrow();

        return Optional.of(mapearMovimientoDto(movimiento));
    }

    @Override
    public List<ObtenerMovimientosDto> obtenerMovimientosCasoUso() {
        List<Movimiento> movimientosDb = movimientoRepositoryPort.obtenerMovimientos();
        HashMap<Long, ObtenerMovimientosDto > jsonMovimientos = new HashMap<>();

        for (Movimiento movimiento : movimientosDb) {
            Long idCuenta = movimiento.getCuenta().getId();
            ObtenerMovimientosDto movimientosDto = new ObtenerMovimientosDto();

            if(!jsonMovimientos.containsKey(idCuenta)) {
                ObtenerMovimientosDto cuentaMapeada = mapearCuentaMovimientoDto(movimiento);
                jsonMovimientos.put(idCuenta, cuentaMapeada);
            }

            MovimientoDTO movimientoMapeado= mapearMovimientoDto(movimiento);

            jsonMovimientos.get(idCuenta).getMovimientos().add(movimientoMapeado);
        }
        return new ArrayList<>(jsonMovimientos.values());
    }


    private ObtenerMovimientosDto mapearCuentaMovimientoDto( Movimiento movimiento){
        ObtenerMovimientosDto movimientosDto = new ObtenerMovimientosDto();
        movimientosDto.setId(movimiento.getCuenta().getId());
        movimientosDto.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
        movimientosDto.setTipoCuenta(movimiento.getCuenta().getTipoCuenta());
        movimientosDto.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
        movimientosDto.setEstado(movimiento.getCuenta().getEstado());
        movimientosDto.setMovimientos(new ArrayList<>());

        return movimientosDto;
    }

    private MovimientoDTO mapearMovimientoDto(Movimiento movimiento){
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setValor(movimiento.getValor());
        movimientoDTO.setSaldo(movimiento.getSaldo());

        return movimientoDTO;
    }

}
