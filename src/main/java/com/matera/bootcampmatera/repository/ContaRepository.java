package com.matera.bootcampmatera.repository;

import com.matera.bootcampmatera.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    /**
     * get
     * find
     * stream
     * read
     * query
     */
    Conta agencia(String agencia);

    Conta findByAgencia(String agencia);

    Conta findByTitularCpf(String cpf);

    @Query("select c from Conta c order by c.numeroConta asc")
    Conta buscarContasOrdenadas();

    @Query("select c from Conta c where c.agencia = :agencia")
    List<Conta> buscarContaPorAgencia(@Param("agencia") String agenciaComOutroNome);

    @Query(value = "select * from CONTA c where c.agencia = ?1", nativeQuery = true)
    List<Conta> buscarContaPorAgenciaComQueryNativa(String agenciaComOutroNome);
}
