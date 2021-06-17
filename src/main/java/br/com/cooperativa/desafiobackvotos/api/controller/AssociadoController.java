package br.com.cooperativa.desafiobackvotos.api.controller;

import br.com.cooperativa.desafiobackvotos.api.domain.dtos.AssociadoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.AssociadoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.service.AssociadoService;
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
@RequestMapping(value = "/associados")
@Tag(name = "Associados", description = "Operações para manter associados")
@RequiredArgsConstructor
public class AssociadoController {

    private final AssociadoService service;

    @GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retorna relação de associados")
    public ResponseEntity<List<AssociadoOutputDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Realiza o cadastro do associado")
    public ResponseEntity<Void> save(@Valid @RequestBody AssociadoInputDTO inputDTO) {
        service.save(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
