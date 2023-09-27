package com.matera.bootcampmatera;

import com.matera.bootcampmatera.model.Conta;
import com.matera.bootcampmatera.repository.ContaRepository;
import io.restassured.RestAssured;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContaIntegrationTest {

    @Autowired
    private ContaRepository contaRepository;

    @LocalServerPort
    public int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void deveRetornarOkQuandoChamamosTodasAsContas() {

        RestAssured
            .given()
            .when()
            .get("/contas")
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract();
    }

    @Test
    void deveRetornarConta(){

        Conta conta = new Conta();
        conta.setNumeroConta("3");
        conta.setAgencia("001");
        conta.setSaldo(BigDecimal.valueOf(400));

        contaRepository.save(conta);

        Conta contaQueRetorna = RestAssured
            .given()
            .when()
            .get("/contas/{id}", conta.getId())
            .then()
            .statusCode(HttpStatus.OK.value())
            .extract().jsonPath().getObject("", Conta.class);

        Assertions.assertEquals(conta.getId(), contaQueRetorna.getId());
    }

    @Test
    void deveRetornarNotFound(){

        RestAssured
            .given()
            .when()
            .get("/contas/{id}", 1L)
            .then()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .extract();
    }

}
