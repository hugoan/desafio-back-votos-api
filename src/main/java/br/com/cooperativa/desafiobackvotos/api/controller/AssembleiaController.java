package br.com.cooperativa.desafiobackvotos.api.controller;

import br.com.cooperativa.desafiobackvotos.api.domain.dtos.PautaInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.PautaOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.SessaoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.SessaoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.service.AssembleiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/assembleia")
@Tag(name = "Assembleia", description = "Operações para cadastrar pautas, listar e abrir sessões de votação")
@RequiredArgsConstructor
public class AssembleiaController {

    private final AssembleiaService service;

    @PostMapping(value = "/pauta/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Realiza o cadastro da pauta")
    public ResponseEntity<Void> save(@Valid @RequestBody PautaInputDTO inputDTO) {
        service.save(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/pauta/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retorna relação de pautas")
    public ResponseEntity<List<PautaOutputDTO>> findAllPautas() {
        return ResponseEntity.ok(service.findAllPautas());
    }

    @PostMapping(value = "/sessao/abrir", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Realiza o cadastro da pauta")
    public ResponseEntity<Void> save(@Valid @RequestBody SessaoInputDTO inputDTO) {
        service.save(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/sessao/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retorna relação de sessões")
    public ResponseEntity<List<SessaoOutputDTO>> findAllSessoes() {
        return ResponseEntity.ok(service.findAllSessoes());
    }
}
