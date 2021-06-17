package br.com.cooperativa.desafiobackvotos.api.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SESSAO", schema = "DESAFIO_BACK_VOTOS_API")
@Getter
@Setter
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SESSAO_SEQ")
    @SequenceGenerator(name = "SESSAO_SEQ", sequenceName = "SESSAO_SEQ", schema = "DESAFIO_BACK_VOTOS_API", allocationSize = 1)
    @Column(name = "ID_SESSAO", nullable = false)
    private Long id;

    @Column(name = "DATA_HORA_INICIO")
    private LocalDateTime dataHoraInicio;

    @Column(name = "DATA_HORA_FIM")
    private LocalDateTime dataHoraFim;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_PAUTA")
    private Pauta pauta;

}
