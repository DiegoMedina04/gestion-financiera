package com.example.micro2.infraestructura.repositories.cuenta;

import com.example.micro2.domian.models.Cuenta;
import com.example.micro2.domian.ports.out.CuentaRepositoryPort;
import com.example.micro2.infraestructura.models.CuentaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCuentaRepositoryAdapter implements CuentaRepositoryPort {

    private final JpaCuentaRepository cuentaRepository;

    public JpaCuentaRepositoryAdapter(JpaCuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository
                .findAll()
                .stream()
                .map(CuentaEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id).map(CuentaEntity::toDomainModel);
    }

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        CuentaEntity cuentaEntity = CuentaEntity.fromDomainModel(cuenta);
        CuentaEntity cuentaGuardada = cuentaRepository.save(cuentaEntity);
        return cuentaGuardada.toDomainModel();
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        CuentaEntity cuentaEntity = CuentaEntity.fromDomainModel(cuenta);
        CuentaEntity cuentaGuardada = cuentaRepository.save(cuentaEntity);
        return cuentaGuardada.toDomainModel();
    }

    @Override
    public Boolean eliminarCuenta(Long id) {
        if(cuentaRepository.existsById(id)) {
            cuentaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
