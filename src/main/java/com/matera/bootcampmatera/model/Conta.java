package com.matera.bootcampmatera.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity // CONTA
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero")
    private String numeroConta; //NUMERO_CONTA
    private String agencia; // AGENCIA


    public Conta(){}
    public Conta(Long id, String numeroConta, String agencia) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }
}

/**
 *                          @Component
 * @Controller              @Service            @Repository
 *
 * @RestController
 *
 */
