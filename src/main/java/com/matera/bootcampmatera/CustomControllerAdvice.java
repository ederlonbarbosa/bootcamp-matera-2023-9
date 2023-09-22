package com.matera.bootcampmatera;

import com.matera.bootcampmatera.exception.ContaInvalidaException;
import com.matera.bootcampmatera.exception.MensagemErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ContaInvalidaException.class)
    public ResponseEntity<MensagemErro> contaInvalidaException(ContaInvalidaException ex) {
        MensagemErro mensagemErro = new MensagemErro(ex.getMessage());
        return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
    }
}
