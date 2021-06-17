package br.com.cooperativa.desafiobackvotos.api.domain.entity;

import br.com.cooperativa.desafiobackvotos.api.domain.enumeration.TipoVoto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VOTO", schema = "DESAFIO_BACK_VOTOS_API")
@Getter
@Setter
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOTO_SEQ")
    @SequenceGenerator(name = "VOTO_SEQ", sequenceName = "VOTO_SEQ", schema = "DESAFIO_BACK_VOTOS_API", allocationSize = 1)
    @Column(name = "ID_VOTO", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "VOTO")
    @Enumerated(EnumType.STRING)
    private TipoVoto voto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_ASSOCIADO")
    private Associado associado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_SESSAO")
    private Sessao sessao;

}
