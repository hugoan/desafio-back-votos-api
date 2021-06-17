package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import br.com.cooperativa.desafiobackvotos.api.domain.enumeration.TipoVoto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Schema(name = "VotoInput")
public class VotoInputDTO {

    @NotNull
    private Long idAssociado;

    @NotNull
    private Long idPauta;

    @NotNull
    @Schema(description = "Sim ou Não")
    private TipoVoto voto;

}
