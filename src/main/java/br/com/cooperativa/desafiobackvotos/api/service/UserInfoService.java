package br.com.cooperativa.desafiobackvotos.api.service;

import br.com.cooperativa.desafiobackvotos.api.client.UserInfoApiClient;
import br.com.cooperativa.desafiobackvotos.api.exceptions.NegocioException;
import br.com.cooperativa.desafiobackvotos.api.exceptions.NotFoundException;
import br.com.cooperativa.desafiobackvotos.api.helpers.MessageHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoApiClient apiClient;
    private final MessageHelper messageHelper;
    private final ObjectMapper objectMapper;

    public String consultarStatusVotacaoAssociado(String cpf) {
        try {
            var response = apiClient.consultarStatusVotacaoAssociado(cpf);
            return objectMapper.readTree(response).requiredAt("/status").asText();
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new NotFoundException(messageHelper.getMessage(e.getMessage()));
        } catch (JsonProcessingException e) {
            throw new NegocioException(messageHelper.getMessage("erro.processar.requisicao", e.getMessage()));
        }
    }

}
