package com.matera.bootcampmatera.controller;

import com.matera.bootcampmatera.exception.ContaInvalidaException;
import com.matera.bootcampmatera.model.Conta;
import com.matera.bootcampmatera.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {
//  1 maneira
//    @Autowired
//    private ContaService contaService;

    // 2 maneira e adicionando no onstrutor ou usando @RequiredArgsConstructor do lombok
//    private final ContaService contaService;
//    public ContaController(ContaService contaService) {
//        this.contaService = contaService;
//    }

    private final ContaService contaService;

    @GetMapping
    public List<Conta> teste() {
        return contaService.getContas();
    }

    @PostMapping
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta) throws ContaInvalidaException {
//        return ResponseEntity.ok(contaService.criarOuAtualizar(conta));
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.criarOuAtualizar(conta));
    }

    // http://localhost:8080/contas/1
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        Optional<Conta> contaOptional = contaService.buscaPorId(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizar(@PathVariable Long id, @RequestBody Conta contaAtualizada) throws ContaInvalidaException {
        Optional<Conta> contaOptional = contaService.buscaPorId(id);

        if (contaOptional.isPresent()) {
            contaAtualizada.setId(id);
            contaService.criarOuAtualizar(contaAtualizada);
            return ResponseEntity.ok(contaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Conta> contaOptional = contaService.buscaPorId(id);

        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            contaService.delete(conta);
            return ResponseEntity.noContent().build(); //204
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // 3 maneira "setinjection"
//    private ContaService contaService;
//
//    @Autowired
//    public void setContaService(ContaService contaService) {
//        this.contaService = contaService;
//    }
}
