package com.example.micro2.infraestructura.models;


import com.example.micro2.domian.models.Cuenta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "cuentas")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    private Long numeroCuenta;

    private String tipoCuenta;

    private Double saldoInicial;

    private Boolean estado;

    private Long clienteId;

//    @JsonManagedReference
    @OneToMany(mappedBy = "cuenta")
    private List<MovimientoEntity> movimientos;

    public CuentaEntity(Long id, Long numeroCuenta, String tipoCuenta, Double saldoInicial, Boolean estado, Long clienteId) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteId = clienteId;
    }

    public static CuentaEntity fromDomainModel(Cuenta cuenta){
        return  new CuentaEntity(
                cuenta.getId(),
                cuenta.getNumeroCuenta(),
                cuenta.getTipoCuenta(),
                cuenta.getSaldoInicial(),
                cuenta.getEstado(),
                cuenta.getClienteId()

        );
    }

    public Cuenta toDomainModel(){
        return new Cuenta(
                id,
                numeroCuenta,
                tipoCuenta,
                saldoInicial,
                estado,
                clienteId
        );
    }

}
