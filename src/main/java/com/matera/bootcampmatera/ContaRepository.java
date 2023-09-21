package com.matera.bootcampmatera;

import com.matera.bootcampmatera.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta agencia(String agencia);

    Conta findByAgencia(String agencia);
    /**
     * get
     * find
     * stream
     * read
     * query
     */
}
