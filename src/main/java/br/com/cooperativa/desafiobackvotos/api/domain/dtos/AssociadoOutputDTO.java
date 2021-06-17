package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "AssociadoOutput")
public class AssociadoOutputDTO {

    private Long id;
    private String cpf;

}
