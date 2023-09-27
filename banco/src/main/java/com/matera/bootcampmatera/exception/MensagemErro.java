package com.matera.bootcampmatera.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensagemErro {

    private String mensagem;
    private LocalDateTime timestamp;

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }
}
