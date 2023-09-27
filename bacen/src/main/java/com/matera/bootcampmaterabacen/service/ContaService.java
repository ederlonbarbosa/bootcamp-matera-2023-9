package com.matera.bootcampmaterabacen.service;

import com.matera.bootcampmaterabacen.dto.Conta;
import com.matera.bootcampmaterabacen.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta get(String chavePix) {
        return contaRepository.findByChavePix(chavePix);
    }
}
