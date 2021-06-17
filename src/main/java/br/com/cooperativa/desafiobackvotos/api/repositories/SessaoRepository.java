package br.com.cooperativa.desafiobackvotos.api.repositories;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Boolean existsSessaoByPauta_Id(Long idPauta);

    Optional<Sessao> findByPauta_id(Long idPauta);

}
