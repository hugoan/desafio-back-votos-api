package br.com.cooperativa.desafiobackvotos.api.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PAUTA", schema = "DESAFIO_BACK_VOTOS_API")
@Getter
@Setter
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAUTA_SEQ")
    @SequenceGenerator(name = "PAUTA_SEQ", sequenceName = "PAUTA_SEQ", schema = "DESAFIO_BACK_VOTOS_API", allocationSize = 1)
    @Column(name = "ID_PAUTA", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
}
