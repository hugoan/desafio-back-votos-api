package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PautaOutput")
public class PautaOutputDTO {

    private Long id;

    private String descricao;
}
