package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Schema(name = "SessaoInput")
public class SessaoInputDTO {

    @NotNull
    @Schema(required = true)
    private Long idPauta;

    @Schema(description = "Informe o tempo em MINUTOS que a sessão deverá ficar disponível")
    private Integer duracao;

}
