package br.com.cooperativa.desafiobackvotos.api.repositories;

import br.com.cooperativa.desafiobackvotos.api.domain.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Boolean existsAssociadoByCpf(String cpf);

    Optional<Associado> findByCpf(String cpf);

    Optional<Associado> deleteByCpf(String cpf);

}
