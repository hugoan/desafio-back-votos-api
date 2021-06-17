package br.com.cooperativa.desafiobackvotos.api.repositories;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Voto;
import br.com.cooperativa.desafiobackvotos.api.domain.enumeration.TipoVoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    Boolean existsVotoByAssociado_IdAndSessao_Pauta_Id(Long idAssociado, Long idPauta);

    Integer countVotoBySessao_idAndVoto(Long idSessao, TipoVoto voto);

}
