package com.matera.bootcampmatera.client;

import com.matera.bootcampmatera.dto.ContaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bacenClient", url="http://localhost:8081") //TODO: colocar como property
public interface BacenClient {

    @RequestMapping(path = "/contas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void criarConta(@RequestBody ContaDTO conta);

}
