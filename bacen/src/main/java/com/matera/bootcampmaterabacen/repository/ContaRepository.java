package com.matera.bootcampmaterabacen.repository;

import com.matera.bootcampmaterabacen.dto.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta findByChavePix(String chavePix);
}
