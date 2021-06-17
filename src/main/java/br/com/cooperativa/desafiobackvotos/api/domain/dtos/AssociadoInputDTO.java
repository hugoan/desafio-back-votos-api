package br.com.cooperativa.desafiobackvotos.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

import static br.com.cooperativa.desafiobackvotos.api.utils.MaskUtils.unmask;

@Getter
@Setter
@Schema(name = "AssociadoInput")
public class AssociadoInputDTO {

    @NotBlank
    @CPF
    @Schema(required = true)
    @Setter(AccessLevel.NONE)
    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = unmask(cpf);
    }

}
