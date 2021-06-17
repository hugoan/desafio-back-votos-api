package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Pauta;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(name = "SessaoOutput")
public class SessaoOutputDTO {

    private Pauta pauta;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

}
