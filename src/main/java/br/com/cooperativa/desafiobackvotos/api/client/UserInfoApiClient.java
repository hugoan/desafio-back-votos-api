package br.com.cooperativa.desafiobackvotos.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userInfoApiClient", url = "${desafio-back-votos-api.user-info-api-url}")
public interface UserInfoApiClient {

    @GetMapping("/users/{cpf}")
    String consultarStatusVotacaoAssociado(@PathVariable(value = "cpf") String cpf);

}