package com.matera.bootcampmaterabacen.controller;

import com.matera.bootcampmaterabacen.dto.Conta;
import com.matera.bootcampmaterabacen.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
@Slf4j
public class ContaController {

    private static Map<String, Conta> cacheContas = new HashMap<>();

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta) {
        cacheContas.put(conta.getChavePix(), conta);

        Conta contaCriada = contaService.save(conta);

        return ResponseEntity.ok(contaCriada);
    }

    @GetMapping("/{chavePix}")
    public ResponseEntity<Conta> obterConta(@PathVariable String chavePix) {
        Conta conta = cacheContas.get(chavePix);

        if (conta == null) {
            log.info("Buscando Conta com chavePix {} na base de dados...", chavePix);
            return ResponseEntity.ok(contaService.get(chavePix));
        }

        log.info("A Conta com chavePix {} encontrada no cache.", chavePix);

        return ResponseEntity.ok(conta);
    }

}


//        Titular titular = conta.getTitular();
//        Titular titularSalvo = titularService.criarOuAtualizar(titular);
//        conta.setTitular(titularSalvo);
//        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.criarOuAtualizar(conta));
