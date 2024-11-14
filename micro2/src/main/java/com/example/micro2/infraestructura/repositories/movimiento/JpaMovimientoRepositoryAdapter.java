package com.example.micro2.infraestructura.repositories.movimiento;

import com.example.micro2.domian.models.Movimiento;
import com.example.micro2.domian.ports.out.MovimientoRepositoryPort;
import com.example.micro2.infraestructura.models.CuentaEntity;
import com.example.micro2.infraestructura.models.Dtos.CuentaDTO;
import com.example.micro2.infraestructura.models.Dtos.MovimientoDTO;
import com.example.micro2.infraestructura.models.Dtos.MovimientoResponseDTO;
import com.example.micro2.infraestructura.models.MovimientoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class JpaMovimientoRepositoryAdapter implements MovimientoRepositoryPort {

    private final JpaMovimientoRepository movimientoRepository;

    public JpaMovimientoRepositoryAdapter(JpaMovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public List<Movimiento> obtenerMovimientos() {
        return movimientoRepository.findAll().
                stream()
                .map(MovimientoEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id).map(MovimientoEntity::toDomainModel);
    }

    @Override
    public Movimiento agregarMovimiento(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = MovimientoEntity.fromDomainModel(movimiento);
        MovimientoEntity movimientoGuardado = movimientoRepository.save(movimientoEntity);
        return movimientoGuardado.toDomainModel();
    }

    @Override
    public Movimiento actualizarMovimient(Movimiento cuenta) {
        MovimientoEntity movimientoEntity = MovimientoEntity.fromDomainModel(cuenta);
        MovimientoEntity movimientoGuardado = movimientoRepository.save(movimientoEntity);
        return movimientoGuardado.toDomainModel();

    }

    @Override
    public Boolean eliminarMovimiento(Long id) {
        if(movimientoRepository.existsById(id)) {
            movimientoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public MovimientoResponseDTO obtenerMovimientosPorFechaYCliente(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId) {
        MovimientoResponseDTO movimientoResponseDTO = new MovimientoResponseDTO();
        ArrayList<MovimientoDTO> movimientos = new ArrayList<>();
         movimientoRepository
                .findMovimientosByFechaAndCliente(fechaInicio, fechaFin, clienteId)
                .stream().forEach(movimiento -> {
                    CuentaDTO cuentaDTO = new CuentaDTO(
                            movimiento.getCuenta().getId(),
                            movimiento.getCuenta().getNumeroCuenta(),
                            movimiento.getCuenta().getTipoCuenta(),
                            movimiento.getCuenta().getSaldoInicial(),
                            movimiento.getCuenta().getEstado(),
                            movimiento.getCuenta().getClienteId()
                    );
                    MovimientoDTO movimientoDto= new MovimientoDTO(
                            movimiento.getId(),
                            movimiento.getFecha(),
                            movimiento.getTipoMovimiento(),
                            movimiento.getValor(),
                            movimiento.getSaldo()
                    );
                     movimientos.add(movimientoDto);
                    movimientoResponseDTO.setCuenta(cuentaDTO);

                });
        movimientoResponseDTO.setMovimiento(movimientos);
        return movimientoResponseDTO;
    }
}
