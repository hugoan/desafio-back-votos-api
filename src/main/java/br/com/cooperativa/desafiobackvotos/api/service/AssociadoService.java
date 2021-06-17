package br.com.cooperativa.desafiobackvotos.api.service;

import static br.com.cooperativa.desafiobackvotos.api.Utils.MaskUtils.*;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.AssociadoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.AssociadoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Associado;
import br.com.cooperativa.desafiobackvotos.api.exceptions.NegocioException;
import br.com.cooperativa.desafiobackvotos.api.helpers.MessageHelper;
import br.com.cooperativa.desafiobackvotos.api.repositories.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository repository;
    private final MapperFacade mapper;
    private final MessageHelper messageHelper;

    public void save(AssociadoInputDTO inputDTO) {

        if (existsAssociado(inputDTO)) {
            throw new NegocioException(messageHelper.getMessage("registro.existente.associado"));
        }
        repository.save(mapper.map(inputDTO, Associado.class));
    }

    public List<AssociadoOutputDTO> findAll() {
        var associados = repository.findAll();
        return mapper.mapAsList(associados, AssociadoOutputDTO.class);
    }

    @Transactional
    public void delete(String cpf) {
        cpf = unmask(cpf);
        repository.findByCpf(cpf)
                .map(associado -> repository.deleteByCpf(associado.getCpf()))
                .orElseThrow(() -> new NegocioException(messageHelper.getMessage("erro.excluir.associado")));
    }

    private Boolean existsAssociado(AssociadoInputDTO inputDTO) {
        return repository.existsAssociadoByCpf(inputDTO.getCpf());
    }

}
