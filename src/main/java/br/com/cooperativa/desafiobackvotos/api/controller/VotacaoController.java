package br.com.cooperativa.desafiobackvotos.api.controller;

import br.com.cooperativa.desafiobackvotos.api.domain.dtos.ResultadoVotacaoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.VotoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/votacao")
@Tag(name = "Votação", description = "Operações para registrar o voto e recuperar o resultado das sessões de votação")
@RequiredArgsConstructor
public class VotacaoController {

    private final VotoService service;

    @PostMapping(value = "/votar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Realizar a votação")
    public ResponseEntity<Void> save(@Valid @RequestBody VotoInputDTO inputDTO) {
        service.save(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/resultado/{idPauta}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retorna o resultado da sessão de votação")
    public ResponseEntity<ResultadoVotacaoOutputDTO> consulta(@PathVariable("idPauta") Long idPauta) {
        return ResponseEntity.ok(service.consultResultadoVotacao(idPauta));
    }
}
