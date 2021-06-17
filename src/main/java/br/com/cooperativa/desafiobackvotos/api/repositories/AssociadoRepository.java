package br.com.cooperativa.desafiobackvotos.api.repositories;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Boolean existsAssociadoByCpf(String cpf);

}
