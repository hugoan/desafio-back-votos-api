package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Schema(name = "PautaInput")
public class PautaInputDTO {

    @NotBlank
    @Schema(required = true)
    private String descricao;

}
