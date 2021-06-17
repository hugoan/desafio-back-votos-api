package br.com.cooperativa.desafiobackvotos.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("desafio-back-votos-api")
public class DesafioBackVotosApiProperties {
    private String userInfoApiUrl;
}
