package com.matera.bootcampmatera.service;

import com.matera.bootcampmatera.exception.ContaInvalidaException;
import com.matera.bootcampmatera.model.Conta;
import com.matera.bootcampmatera.repository.ContaRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public Conta criarOuAtualizar(Conta conta) throws ContaInvalidaException {
        if(isNull(conta.getAgencia())){
           throw new ContaInvalidaException(String.format("A conta não possui agencia"));
        }
        return contaRepository.save(conta);
    }

    public Conta debitaConta(Long idConta, BigDecimal valor) throws ContaInvalidaException {
        Optional<Conta> conta = buscaPorId(idConta);
        if (conta.isPresent()){
            conta.get().debito(valor);
            return contaRepository.save(conta.get());
        }
        throw new ContaInvalidaException("Error");
    }

    public Conta creditarConta(Long idConta, BigDecimal valor) throws ContaInvalidaException {
        Optional<Conta> conta = buscaPorId(idConta);
        if (conta.isPresent()){
            conta.get().credito(valor);
            return contaRepository.save(conta.get());
        }
        throw new ContaInvalidaException("Error");
    }

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscaPorId(Long id) {
        return contaRepository.findById(id);
    }

    public void delete(Conta conta) {
        contaRepository.delete(conta);
    }
}
