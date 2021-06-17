package br.com.cooperativa.desafiobackvotos.api.repositories;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    Boolean existsPautaById(Long idPauta);

}
