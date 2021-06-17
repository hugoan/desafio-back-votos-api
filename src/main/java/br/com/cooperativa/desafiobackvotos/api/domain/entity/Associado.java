package br.com.cooperativa.desafiobackvotos.api.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ASSOCIADO", schema = "DESAFIO_BACK_VOTOS_API")
@Getter
@Setter
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSOCIADO_SEQ")
    @SequenceGenerator(name = "ASSOCIADO_SEQ", sequenceName = "ASSOCIADO_SEQ", schema = "DESAFIO_BACK_VOTOS_API", allocationSize = 1)
    @Column(name = "ID_ASSOCIADO", nullable = false)
    private Long id;


    @NotNull
    @Column(name = "CPF")
    private String cpf;

}

