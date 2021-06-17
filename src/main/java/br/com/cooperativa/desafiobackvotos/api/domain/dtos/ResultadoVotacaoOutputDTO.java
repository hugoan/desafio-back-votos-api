package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Sessao;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "ResultadoVotacaoOutput")
public class ResultadoVotacaoOutputDTO {

    private Sessao sessao;

    private Integer totalSim;

    private Integer totalNao;


}
