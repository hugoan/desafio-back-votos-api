package br.com.cooperativa.desafiobackvotos.api.service;

import br.com.cooperativa.desafiobackvotos.api.domain.dtos.PautaInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.PautaOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.SessaoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.SessaoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Pauta;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Sessao;
import br.com.cooperativa.desafiobackvotos.api.exceptions.NegocioException;
import br.com.cooperativa.desafiobackvotos.api.helpers.MessageHelper;
import br.com.cooperativa.desafiobackvotos.api.repositories.PautaRepository;
import br.com.cooperativa.desafiobackvotos.api.repositories.SessaoRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssembleiaService {

    private static final int DEFAULT_UM_MINUTO = 1;

    private final PautaRepository pautaRepository;
    private final SessaoRepository sessaoRepository;
    private final MapperFacade mapper;
    private final MessageHelper messageHelper;

    public void save(PautaInputDTO inputDTO) {
        pautaRepository.save(mapper.map(inputDTO, Pauta.class));
    }

    public List<PautaOutputDTO> findAllPautas() {
        var pautas = pautaRepository.findAll();
        return mapper.mapAsList(pautas, PautaOutputDTO.class);
    }

    public void save(SessaoInputDTO inputDTO) {
        validarPauta(inputDTO);

        var pauta = pautaRepository.findById(inputDTO.getIdPauta());

        Sessao sessao = new Sessao();
        sessao.setPauta(pauta.get());
        sessao.setDataHoraInicio(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        if (inputDTO.getDuracao() == null || inputDTO.getDuracao() < 1) {
            sessao.setDataHoraFim(sessao.getDataHoraInicio().plusMinutes(DEFAULT_UM_MINUTO));
        } else {
            sessao.setDataHoraFim(sessao.getDataHoraInicio().plusMinutes(inputDTO.getDuracao()));
        }

        sessaoRepository.save(sessao);
    }

    public List<SessaoOutputDTO> findAllSessoes() {
        var sessoes = sessaoRepository.findAll();
        return mapper.mapAsList(sessoes, SessaoOutputDTO.class);
    }

    private void validarPauta(SessaoInputDTO inputDTO) {
        if (!pautaRepository.existsPautaById(inputDTO.getIdPauta())) {
            throw new NegocioException(messageHelper.getMessage("registro.inexistente.pauta"));
        }

        if (sessaoRepository.existsSessaoByPauta_Id(inputDTO.getIdPauta())) {
            throw new NegocioException(messageHelper.getMessage("registro.existente.sessao"));
        }
    }

}
