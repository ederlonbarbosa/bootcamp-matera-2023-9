package com.matera.bootcampmatera.service;

import static java.util.Objects.isNull;

import com.matera.bootcampmatera.exception.ContaInvalidaException;
import com.matera.bootcampmatera.model.Conta;
import com.matera.bootcampmatera.model.Titular;
import com.matera.bootcampmatera.repository.TitularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitularService {


    private final TitularRepository titularRepository;

    public Titular criarOuAtualizar(Titular titular)  {
        return titularRepository.save(titular);
    }




}
