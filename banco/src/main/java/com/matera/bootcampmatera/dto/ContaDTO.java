package com.matera.bootcampmatera.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
//@Entity
public class ContaDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numeroConta;
    private String agencia;
    private String chavePix;
    private BigDecimal saldo = BigDecimal.ZERO;
//    @OneToOne
//    private Titular titular;

    public ContaDTO() {
    }


    public ContaDTO(String numeroConta, String agencia, String chavePix) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.chavePix = chavePix;
    }
//
//    public void debito(BigDecimal valor){
//        saldo = saldo.subtract(valor);
//    }
//
//    public void enviarPix(Conta contaDestino, BigDecimal valor) {
//
//        if (this.saldo.compareTo(valor) <= 0){
//            throw new ContaInvalidaException("Conta sem saldo disponível.");
//        }
//
//        this.debito(valor);
//        contaDestino.credito(valor);
//    }
//
//    public void credito(BigDecimal valor){
//        saldo = saldo.add(valor);
//    }

}

/**
 * @Component
 * @Controller @Service            @Repository
 * @RestController
 */
